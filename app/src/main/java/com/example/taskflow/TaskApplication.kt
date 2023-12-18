package com.example.taskflow

import android.app.Application
import com.example.taskflow.data.AppContainer
import com.example.taskflow.data.DefaultContainer

class TaskApplication : Application(){

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultContainer(this)
    }
}