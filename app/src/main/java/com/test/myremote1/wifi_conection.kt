package com.test.myremote1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button


class Activity_wifi_connection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi_conection) // Make sure this points to the correct layout

        // Initialize the "Go to Remote" button
        val btnGoToRemote = findViewById<Button>(R.id.btn_activate)

        // Set click listener for the button
        btnGoToRemote.setOnClickListener {
            // Intent to navigate to ActivityRemoteButton
            val intent = Intent(this, RemoteButtonActivity::class.java)
            startActivity(intent)
        }
    }
}

