package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

    @Database(entities = [Station::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {

        abstract  fun stationDAO():StationsDAO
        companion object {
            @Volatile
            private  var INSTANCE : AppDatabase?=null
            fun getDatabase(context : Context):AppDatabase
            {
                val tempInstance = INSTANCE
                if (tempInstance!=null)
                {
                    return tempInstance
                }
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    ).allowMainThreadQueries().build()
                    INSTANCE = instance
                    return instance
                }
            }

        }
    }
