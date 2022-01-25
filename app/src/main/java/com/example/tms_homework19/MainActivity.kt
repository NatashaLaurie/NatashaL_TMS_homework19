package com.example.tms_homework19


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnScoreActivity = findViewById<Button>(R.id.btn1)

        btnScoreActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, ScoreActivity::class.java)
            startActivity(intent)
        }
        val btnAkamaiActivity = findViewById<Button>(R.id.btn2)

        btnAkamaiActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, AkamaiActivity::class.java)
            startActivity(intent)
        }
    }
}