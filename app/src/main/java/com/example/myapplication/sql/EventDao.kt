package com.example.myapplication.sql

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Query("SELECT * FROM event_roster")
    fun getAll(): List<Event>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(event: Event)
    @Delete
    suspend fun delete(event: Event)

    @Query("DELETE FROM event_roster")
    suspend fun deleteAll()
}