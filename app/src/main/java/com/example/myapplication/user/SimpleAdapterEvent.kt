package com.example.myapplication.user

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.sql.Event
 /*
    This Adapater changes the box to display events
    It is missing something to make changes reflect live.
    Come back to this with viewmodel
  */
const val TAG = "Adapter"
class SimpleAdapterEvent (private val context: Context):
RecyclerView.Adapter<SimpleViewHolder>(){
    private val event_list: ArrayList<Event> = ArrayList()
    override fun getItemCount() = event_list.size

    /*
        This adds to the list
     */
    fun addToList(item: Event){
        Log.d(TAG, "Adding to List: $item")
        event_list.add(item)
        Log.d(TAG, "Adding to List: $event_list")
    }
    fun deleteAll(){
        event_list.clear()

    }
/*
    This one setups up the cells that pop up when in the recycle view window
 */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.event_cell_sheet,parent,false)
        view.layoutParams.height =  (parent.height * 0.16).toInt()
        return SimpleViewHolder(view)
    }
    /*
        This binds a new cell
     */
    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        Log.d(TAG,"Bind ${event_list[position]}")
        holder.bind(event_list[position])
    }
}

class SimpleViewHolder(view: View): RecyclerView.ViewHolder(view){
    var event_cell: TextView = view.findViewById(R.id.event_cellsheet)
    var point_cell: TextView = view.findViewById(R.id.point_cellsheet)
    init{
        Log.d(TAG,"$ Simple View event_cell and $point_cell")
    }

    fun bind(event: Event){
        event_cell.text = event.eventSchool
        point_cell.text = event.points.toString()
    }

}