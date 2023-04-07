package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.sql.AppDatabase
import com.example.myapplication.user.SimpleAdapterEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

const private val TAG = "Student_Debug"
class Student_Event_Fragment : Fragment(R.layout.event_fragment) {
    lateinit var rv_event: RecyclerView
    lateinit var adapter: SimpleAdapterEvent
    private lateinit var eventDb : AppDatabase
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_event = view.findViewById(R.id.rv_event_database)
        rv_event.layoutManager = LinearLayoutManager(requireContext())
        adapter = SimpleAdapterEvent(requireContext())
        rv_event.adapter = adapter
        eventDb = AppDatabase.getDatabase(requireContext())
        updateView()
    }
    private fun updateView(){
        GlobalScope.launch ( Dispatchers.IO) {
            val test = eventDb.eventDao().getAll()

            Log.d(TAG, " $test")



            for (x in test) {
                Log.d(TAG, " $x")
                adapter.addToList(x)
            }
        }
    }
}