package com.example.myapplication.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.myapplication.R
/*
    Not used yet, meant for the setting button
 */
class Setting_fragment: PreferenceFragmentCompat(){
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.setting,rootKey)
    }
}