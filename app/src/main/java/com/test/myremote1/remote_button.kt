package com.test.myremote1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONObject

class RemoteButtonActivity : AppCompatActivity() {

    // Initialize the OkHttpClient for network communication
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Optional: Enable edge-to-edge for better screen usage
        setContentView(R.layout.activity_remote_button)

        // Setup view and buttons
        setupButtons()
    }

    // Function to setup all the buttons and their click listeners
    private fun setupButtons() {
        // Power button - turns TV on/off (or send signal to power API)
        val btnPower: Button = findViewById(R.id.btn_power)
        btnPower.setOnClickListener {
            // Add your power button code here
            Log.d("RemoteButton", "Power button clicked")
            // You can add network call here to send power command to the TV
        }

        // Input button - switch input source
        val btnInput: Button = findViewById(R.id.btn_Input)
        btnInput.setOnClickListener {
            Log.d("RemoteButton", "Input button clicked")
            // Handle input button press (e.g., change TV input)
        }

        // Number buttons - for selecting channels or input
        val btn1: Button = findViewById(R.id.btn_1)
        btn1.setOnClickListener { sendCommand("1") }
        val btn2: Button = findViewById(R.id.btn_2)
        btn2.setOnClickListener { sendCommand("2") }
        val btn3: Button = findViewById(R.id.btn_3)
        btn3.setOnClickListener { sendCommand("3") }
        val btn4: Button = findViewById(R.id.btn_4)
        btn4.setOnClickListener { sendCommand("4") }
        val btn5: Button = findViewById(R.id.btn_5)
        btn5.setOnClickListener { sendCommand("5") }
        val btn6: Button = findViewById(R.id.btn_6)
        btn6.setOnClickListener { sendCommand("6") }
        val btn7: Button = findViewById(R.id.btn_7)
        btn7.setOnClickListener { sendCommand("7") }
        val btn8: Button = findViewById(R.id.btn_8)
        btn8.setOnClickListener { sendCommand("8") }
        val btn9: Button = findViewById(R.id.btn_9)
        btn9.setOnClickListener { sendCommand("9") }
        val btn0: Button = findViewById(R.id.btn_0)
        btn0.setOnClickListener { sendCommand("0") }

        // Volume control buttons
        val btnVolumeUp: Button = findViewById(R.id.btn_volume_up)
        btnVolumeUp.setOnClickListener {
            sendCommand("volume_up")
        }

        val btnVolumeDown: Button = findViewById(R.id.btn_volume_down)
        btnVolumeDown.setOnClickListener {
            sendCommand("volume_down")
        }

        // Channel control buttons
        val btnChannelUp: Button = findViewById(R.id.btn_channel_up)
        btnChannelUp.setOnClickListener {
            sendCommand("channel_up")
        }

        val btnChannelDown: Button = findViewById(R.id.btn_channel_down)
        btnChannelDown.setOnClickListener {
            sendCommand("channel_down")
        }

        // Streaming service buttons
        val btnNetflix: Button = findViewById(R.id.btn_netflix)
        btnNetflix.setOnClickListener {
            sendCommand("netflix")
        }

        val btnAmazon: Button = findViewById(R.id.btn_amazon)
        btnAmazon.setOnClickListener {
            sendCommand("amazon_prime")
        }

        val btnHBO: Button = findViewById(R.id.btn_hbo)
        btnHBO.setOnClickListener {
            sendCommand("hbo")
        }

        val btnYoutube: Button = findViewById(R.id.btn_youtube)
        btnYoutube.setOnClickListener {
            sendCommand("youtube")
        }

        // Voice Command button
        val btnVoice: Button = findViewById(R.id.btn_voice)
        btnVoice.setOnClickListener {
            // Start voice recognition (you can implement voice recognition functionality here)
            Toast.makeText(this, "Voice command activated", Toast.LENGTH_SHORT).show()
            Log.d("RemoteButton", "Voice Command activated")
        }
    }

    // Function to send commands to the TV (can be replaced with your actual network calls)
    private fun sendCommand(command: String) {
        // Here we simulate sending a command to the TV (replace this with actual network logic)
        Log.d("RemoteButton", "Sending command: $command")

        // Example of how to make a POST request to the TV's WebSocket API or REST API
        val requestBody = FormBody.Builder()
            .add("command", command) // Add the command to the body
            .build()

        val request = Request.Builder()
            .url("http://<your_tv_ip>/command") // Replace with your TV's IP and API endpoint
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: java.io.IOException) {
                // Handle error in request (e.g., no network connection)
                Log.e("RemoteButton", "Network request failed: $e")
                runOnUiThread {
                    Toast.makeText(this@RemoteButtonActivity, "Failed to send command", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                // Handle the response from the TV (e.g., command successful)
                if (response.isSuccessful) {
                    Log.d("RemoteButton", "Command sent successfully: ${response.body?.string()}")
                } else {
                    Log.e("RemoteButton", "Failed to send command: ${response.code}")
                }
            }
        })
    }
}
