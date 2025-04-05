package com.test.myremote1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the "ACTIVATE TV remote" button
        val btnActivateTvRemote = findViewById<Button>(R.id.btn_activate_tv_remote)

        // Set click listener for the button
        btnActivateTvRemote.setOnClickListener {
            // Intent to navigate to ActivityWifiConnection
            val intent = Intent(this, Activity_wifi_connection::class.java)
            startActivity(intent)
        }
    }
}
