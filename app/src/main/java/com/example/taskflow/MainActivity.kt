package com.example.taskflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskflow.ui.theme.TaskFlowTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            TaskFlowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize() ,
                        color = MaterialTheme.colorScheme.background
                ) {
                  TaskFlowApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskFlowAppPreview() {
    TaskFlowTheme {
       TaskFlowApp()
    }
}