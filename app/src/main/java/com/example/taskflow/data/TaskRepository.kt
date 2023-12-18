package com.example.taskflow.data

import android.content.Context
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getAllTask() : Flow<List<Task>>

    fun getTask(taskId: String) : Flow<Task>

    suspend fun addTask(task: Task)

    suspend fun updateTask(task: Task)

    suspend fun deleteTask(task: Task)
}


class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {
    override fun getAllTask(): Flow<List<Task>> = taskDao.getAllTask()

    override fun getTask(taskId: String): Flow<Task> = taskDao.getTask(taskId)

    override suspend fun addTask(task: Task) = taskDao.addTask(task)

    override suspend fun updateTask(task: Task) = taskDao.updateTask(task)

    override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)

}