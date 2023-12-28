package com.example.taskflow.ui.screens.addTask

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.taskflow.data.Task
import com.example.taskflow.data.TaskRepository

data class AddItemUiState(
    val taskDetails: TaskDetails = TaskDetails(),
    val isEntryValid: Boolean = false
)

data class TaskDetails(
    val taskId: Int = 0 ,
    val taskTitle: String = "" ,
    val taskDescription: String = "" ,
    val dueDate: String = "" ,
    val priority: Priority = Priority.Basic ,
)
class AddTaskViewModel (private val taskRepository: TaskRepository) : ViewModel(){

    var addItemUiState by mutableStateOf(AddItemUiState())
        private set

    fun updateUiState(taskDetails: TaskDetails){
        addItemUiState = AddItemUiState(taskDetails = taskDetails, isEntryValid = validateInput(taskDetails))
    }

    private fun validateInput(uiState: TaskDetails = addItemUiState.taskDetails): Boolean {
        return with(uiState) {
            taskTitle.isNotBlank() && taskDescription.isNotBlank()
        }
    }

    suspend fun saveTask(){
        if (validateInput()){
            taskRepository.addTask(addItemUiState.taskDetails.toTask())
        }
    }

}

fun TaskDetails.toTask() : Task = Task(
        taskId = taskId,
        taskTitle = taskTitle,
        taskDescription = taskDescription,
        dueDate = dueDate,
        priority = priority
)