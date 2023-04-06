package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.user.App

class Homepage_fragment : Fragment(R.layout.homepage) {

    private lateinit var qrbtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVar(view)
        onClickListen()

    }
    /*
        Function to initalize variables.
     */
    private fun initVar(view: View){
        qrbtn = view.findViewById(R.id.btn_qr)
        (activity as AppCompatActivity).supportActionBar?.title = "Hello, ${App.user}"
    }
/*
    Group up all on click requests.
 */
    private fun onClickListen(){
        qrbtn.setOnClickListener { onQRClick() }

    }
    /*
        Redirect to QR
     */
    private fun onQRClick(){
        val directions = Homepage_fragmentDirections.actionFragHomepageToFragQrcode()
        findNavController().navigate(directions)
    }
}