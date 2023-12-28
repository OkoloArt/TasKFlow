package com.example.taskflow.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromSubTasksList(subTasks: List<SubTasks>): String {
        return Gson().toJson(subTasks)
    }

    @TypeConverter
    fun toSubTasksList(subTasksString: String): List<SubTasks> {
        val type = object : TypeToken<List<SubTasks>>() {}.type
        return Gson().fromJson(subTasksString, type)
    }
}