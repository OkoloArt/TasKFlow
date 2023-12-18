package com.example.taskflow.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.taskflow.TaskApplication
import com.example.taskflow.ui.screens.addTask.AddTaskViewModel
import com.example.taskflow.ui.screens.home.HomeViewModel
import com.example.taskflow.ui.screens.taskDetail.TaskDetailViewModel

object AppViewModelProvider {
    val factory = viewModelFactory {
        initializer {
            HomeViewModel(taskApplication().container.taskRepository)
        }

        initializer {
            AddTaskViewModel(taskApplication().container.taskRepository)
        }

        initializer {
            TaskDetailViewModel(this.createSavedStateHandle(),
            taskApplication().container.taskRepository)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.taskApplication(): TaskApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TaskApplication)