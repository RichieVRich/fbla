package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        /* Basic Jurgan */
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* Start Code */
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val loginBTN = findViewById<Button>(R.id.btn_login)
        val userName = findViewById<EditText>(R.id.username)

    }
}