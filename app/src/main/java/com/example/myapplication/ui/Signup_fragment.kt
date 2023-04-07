package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R

/*
    To be used to take input and insert to a sql database
    The button will be used to transfer and to navigate back to the login screen.
 */
class Signup_fragment: Fragment(R.layout.signup){
    lateinit var btn_create: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_create = view.findViewById(R.id.btn_create)
        btn_create.setOnClickListener {
            val directions = Signup_fragmentDirections.actionFragSignupToFragLogin()
            findNavController().navigate(directions)
        }
    }
}