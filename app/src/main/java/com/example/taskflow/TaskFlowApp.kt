package com.example.taskflow

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskflow.ui.screens.addTask.AddTaskScreen
import com.example.taskflow.ui.screens.home.HomeScreen
import com.example.taskflow.ui.screens.taskDetail.TaskDetailScreen

enum class Screen(){
    Home,
    Details,
    AddTask
}
@Composable
fun TaskFlowApp(){

    val navController = rememberNavController()

    NavHost(navController = navController  , startDestination = Screen.Home.name ){
        composable(Screen.Home.name){
            HomeScreen(navigateToAddTask = {navController.navigate(Screen.AddTask.name)} ,
                       navigateToDetails = {navController.navigate(Screen.Details.name)})
        }
        composable(Screen.Details.name){
            TaskDetailScreen(navigateBack = {navController.navigate(Screen.Home.name)})
        }
        composable(Screen.AddTask.name){
            AddTaskScreen(navigateBack = { navController.navigate(Screen.Home.name)})
        }
    }
}