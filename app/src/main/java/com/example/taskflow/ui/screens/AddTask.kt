package com.example.taskflow.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(modifier: Modifier = Modifier){

    var taskTitle by rememberSaveable { mutableStateOf("") }
    var taskDescription by rememberSaveable { mutableStateOf("") }

    Scaffold(topBar = { AddTaskTopBar() }) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(10.dp)) {
            Text(text = "Task")
            Spacer(modifier = Modifier.height(13.dp))
            InputText(
                    text = taskTitle ,
                    onTextChange = { taskTitle = it } ,
                    singleLine = true ,
                    modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "What's the task all about?")
            Spacer(modifier = Modifier.height(12.dp))
            InputText(
                    text = taskDescription ,
                    onTextChange = { taskDescription = it } ,
                    singleLine = false ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp))
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Due Date")
            Spacer(modifier = Modifier.height(12.dp))
            DateSelection()
            Spacer(modifier = Modifier.height(12.dp))
            Text(text ="Task Priority" )
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                TaskType(onClick = false  , priority = "Basic", Modifier.weight(1f) )
                Spacer(modifier = modifier.width(8.dp))
                TaskType(onClick = false  , priority = "Urgent", Modifier.weight(1f) )
                Spacer(modifier = modifier.width(8.dp))
                TaskType(onClick = true  , priority = "Important", Modifier.weight(1f) )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { /*TODO*/ },
                   modifier = Modifier.fillMaxWidth()) {
                Text(text = "Create Task")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskTopBar(modifier: Modifier = Modifier){
    TopAppBar(
            title = { /*TODO*/ } ,
            navigationIcon = {
                // Image on the left
                Image(
                        imageVector = Icons.Outlined.KeyboardArrowLeft ,
                        contentDescription = null ,
                        contentScale = ContentScale.Crop ,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp)
                )
            } ,
    )
}

@Composable
fun TaskType(onClick: Boolean, priority: String, modifier: Modifier = Modifier){
    Box(modifier = modifier
        .clickable { !onClick }
        .background(
                color = if (onClick) Color.Red else Color.White ,
                shape = RoundedCornerShape(13.dp)
        ) ,
        contentAlignment = Alignment.Center) {
        Text(text = priority,
             modifier = Modifier.padding(top = 5.dp, start = 12.dp, end = 12.dp, bottom = 5.dp),
             color = if (onClick) Color.White else Color.Black)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputText(
    modifier: Modifier = Modifier ,
    text: String ,
    onTextChange: (String) -> Unit ,
    singleLine: Boolean , ) {

    OutlinedTextField(
            value = text,
            onValueChange = { onTextChange(it) },
            singleLine = singleLine,
            label = { Text(text = "TasK Title")},
            modifier = modifier,
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Color.Transparent,
//                    unfocusedBorderColor = Color.Transparent
//            )
    )
}

@Composable
fun DateSelection(modifier: Modifier = Modifier){

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White , shape = RoundedCornerShape(13.dp)),) {
        Text(text = "October" ,
             modifier = Modifier
                 .padding(top = 8.dp , start = 12.dp , end = 12.dp , bottom = 8.dp)
                 .align(alignment = Alignment.CenterVertically)
                 .weight(1f),
             color = Color.Black ,)
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(
                onClick = { /*TODO*/ } ,
                modifier = Modifier
                    .padding(top = 8.dp , start = 12.dp , end = 12.dp , bottom = 8.dp)
        ) {
            Icon(
                    imageVector = Icons.Outlined.DateRange ,
                    contentDescription = null ,
            )
        }
    }

}


