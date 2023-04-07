package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.sql.AppDatabase
import com.example.myapplication.sql.Event
import com.example.myapplication.user.SimpleAdapterEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

const private val TAG = "Admin_Debug"
class Admin_fragment: Fragment(R.layout.activity_admin) {


    private lateinit var eventDb : AppDatabase

    lateinit var btn_add : Button
    lateinit var btn_delete: Button
    lateinit var btn_read: Button
    lateinit var spinner_event : Spinner
    lateinit var spinner_pts : Spinner
    lateinit var rv_event: RecyclerView
    lateinit var adapter: SimpleAdapterEvent


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_add = view.findViewById(R.id.btn_add_event)
        btn_delete = view.findViewById(R.id.btn_delete_event)
        btn_read =  view.findViewById(R.id.btn_read_event)
        spinner_event =  view.findViewById(R.id.spinner_events)
        spinner_pts = view.findViewById(R.id.spinner_points)
        rv_event = view.findViewById(R.id.rv_event_database)
        rv_event.layoutManager = LinearLayoutManager(requireContext())

        adapter = SimpleAdapterEvent(requireContext())
        rv_event.adapter = adapter
        eventDb = AppDatabase.getDatabase(requireContext())
        val runner = Event(
            1,"Dance",1
        )
        updateView()
        //adapter.addToList(runner)


        btn_add.setOnClickListener {
            writeData()
        }
        btn_read.setOnClickListener {
            updateView()
        }
        btn_delete.setOnClickListener {
            deleteAll()
        }

    }
    private fun writeData(){
        val eventSchool = spinner_event.selectedItem.toString() // Extracted Selected Option
        val points = spinner_pts.selectedItem.toString()
        Log.d(TAG,"Set Element: $eventSchool and Points: $points")
        val event_package = Event(
            null,eventSchool, points.toInt()
        )
        adapter.addToList(event_package)
        GlobalScope.launch(Dispatchers.IO) {
            eventDb.eventDao().insert(event_package)
        }

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

    private fun deleteAll() {
        GlobalScope.launch(Dispatchers.IO) {
            eventDb.eventDao().deleteAll()
        }
        adapter.deleteAll()
        updateView()
    }
}