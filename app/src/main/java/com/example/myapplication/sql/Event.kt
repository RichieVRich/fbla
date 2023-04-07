package com.example.myapplication.sql

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_roster")
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "eventSchool") val eventSchool: String?,
    @ColumnInfo(name = "points") val points: Int?
)
