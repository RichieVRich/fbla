package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class login_fragment: Fragment(R.layout.activity_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        var btnLogin: Button = view.findViewById(R.id.btn_login)
        var username: TextView = view.findViewById(R.id.username)
    }
}