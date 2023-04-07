package com.example.myapplication.sql

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// Access Database Commands
// Data Access Objects (DAO) gets the entities from the database and stores changes to the db
// Essentially this is the interface that communicates with the database to access and modify the database.
@Dao
interface StudentDao {
    @Insert
    suspend fun insert(student: Student)
    @Update
    suspend fun update(student: Student)
    @Delete
    suspend fun delete(student: Student)

    @Query( "SELECT * FROM `student-sheet`")
    fun getAll() : List<Student>
}