package com.example.taskflow.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskflow.ui.screens.addTask.Priority

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var taskId: Int = 0 ,
    var taskTitle: String = "" ,
    var taskDescription: String = "" ,
    var dueDate: String = "" ,
    var priority: Priority ,
    var subTasks: List<SubTasks> = emptyList()
)


data class SubTasks(
    var subtaskTitle: String = "" ,
    var subtaskDescription : String = ""
)