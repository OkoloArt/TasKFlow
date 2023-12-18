package com.example.taskflow.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.taskflow.data.Task
import com.example.taskflow.data.TaskRepository

class HomeViewModel (taskRepository: TaskRepository) : ViewModel(){

}

data class HomeUiState(val taskList: List<Task> = listOf())
