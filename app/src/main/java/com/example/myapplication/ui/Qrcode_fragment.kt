package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.R
/*
    Need an API to hook up to generate a new QRcode when not present
    otherwise refer to database QRcode.
 */
class Qrcode_fragment:Fragment (R.layout.activity_qrcode){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}