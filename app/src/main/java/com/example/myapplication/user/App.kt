package com.example.myapplication.user

import android.app.Application

class App:Application() {
    companion object{
        /*
            Used to display the Hello, Name
         */
        lateinit var user: String
    }
}