package com.example.taskflow.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskflow.ui.screens.addTask.Priority

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val taskId: Int = 0 ,
    val taskTitle: String = "" ,
    val taskDescription: String = "" ,
    val dueDate: String = "" ,
    val priority: Priority = Priority.Basic ,
   // val subTasks: List<SubTasks> = emptyList()
)

data class SubTasks(
    val subtaskTitle: String = "" ,
    val subtaskDescription : String = ""
)