package com.example.myapplication.sql

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room


const val DATABASE_NAME = "event-db"
/*
    This is the database represented as an abstract class that inheirts from the roomdatabase class.

 */
/*
@Database(entities = [Student:: class], version = 1)



abstract class AppDatabase: RoomDatabase() {
    abstract fun StudentDao() : StudentDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context:Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
    }
}*/
@Database(entities = [Event :: class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun eventDao() : EventDao

    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            /*
                This operation makes it so if it is called 3 times it doesnt make 3 i waits and corrects as it goes.
             */
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "event_db"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}
