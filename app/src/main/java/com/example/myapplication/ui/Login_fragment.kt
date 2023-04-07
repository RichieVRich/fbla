package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.user.App

class Login_fragment: Fragment(R.layout.activity_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        var btnLogin: Button = view.findViewById(R.id.btn_login)
        var btncreate: Button = view.findViewById(R.id.btn_createacc)
        var username: TextView = view.findViewById(R.id.username)
        var password: TextView = view.findViewById(R.id.password)

/*  This is the login button, it is set to listen to when it is clicked.
    When it is clicked it checks both inputs to make sure they are not empty.
    If they are empty the user is prevented to progress until both are filled.
 */
        btnLogin.setOnClickListener {

                if (username.text.isNotEmpty() && password.text.isNotEmpty() ) {
                    val user = username.text.toString()
                    val password = password.text.toString()
                    App.user = user
                    // Yes this isn't safe
                    // Remove this when profile database is setup
                    if (user == "Admin" && password == "123") {
                        onAdminClick()
                    } else {
                        onLoginClick()
                    }

                } else {
                    val text = "Username and password are required."
                    val duration = Toast.LENGTH_SHORT
                    Toast.makeText(activity, text, duration).show()
                }

        }
        /*
            This button will redirect the user to the signup_fragment
         */
        btncreate.setOnClickListener {
            onCreateClick()
        }

    }
    /*
        This function will accept the two inputs and then move forward
        Redirects to the homepage fragment
     */
    private fun onLoginClick(){
        val directions = Login_fragmentDirections.actionFragLoginToFragHomepage()
        findNavController().navigate(directions)
    }
    /*
        This function is to be called instead when the administrator is logging into the app
        Redirects to the admin fragment
     */
    private fun onAdminClick(){
        val directions = Login_fragmentDirections.actionFragLoginToFragAdmin()
        findNavController().navigate(directions)
    }
    /*
        This function redirects to the signup_fragment
     */
    private fun onCreateClick(){
        val directions = Login_fragmentDirections.actionFragLoginToFragSignup()
        findNavController().navigate(directions)
    }
}