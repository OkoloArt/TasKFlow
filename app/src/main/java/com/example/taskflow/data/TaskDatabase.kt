package com.example.taskflow.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], exportSchema = false, version = 1)
abstract class TaskDatabase : RoomDatabase(){
    abstract fun getTaskDao() : TaskDao

    companion object {
         @Volatile
         private var Instance : TaskDatabase? = null

        fun getDatabase(context : Context) : TaskDatabase {

            return Instance ?: synchronized(this){

                Room.databaseBuilder(context, TaskDatabase::class.java, "task_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }

            }
        }
    }
}