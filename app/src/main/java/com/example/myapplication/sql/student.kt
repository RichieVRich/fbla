package com.example.myapplication.sql

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "student-sheet")
/*
    This is the room database
    Using the room persistence library we can use SQLite to incorporate on-device persistence on to the app
    This is the Entities used to get and set values.
 */
data class Student (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String?,
    val number: Int?,
    val passcode: String?
): Serializable