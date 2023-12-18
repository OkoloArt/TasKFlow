package com.example.taskflow.data

import android.content.Context

interface AppContainer {

    val taskRepository : TaskRepository
}


class DefaultContainer(private val context: Context) : AppContainer {

    override val taskRepository: TaskRepository by lazy {
        TaskRepositoryImpl(TaskDatabase.getDatabase(context = context).getTaskDao())
    }
}
