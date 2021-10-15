package com.example.taller3madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIr = findViewById<Button>(R.id.btnIr)
        btnIr.setOnClickListener { goToSecondActivity()

        }


    }
    fun goToSecondActivity(){

        val secondIntent = Intent(this, SecondActivity::class.java)
        startActivity(secondIntent)
    }
}