package com.example.taskflow.ui.screens.addTask

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.taskflow.ui.AppViewModelProvider
import kotlinx.coroutines.launch

enum class Priority {
    Basic,
    Urgent,
    Important
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(navigateBack: () -> Unit,
                  modifier: Modifier = Modifier,
                  viewModel: AddTaskViewModel = viewModel(factory = AppViewModelProvider.factory)){

  //  var taskTitle by rememberSaveable { mutableStateOf("") }
    var taskDescription by rememberSaveable { mutableStateOf("") }
    var selectedPriority by rememberSaveable { mutableStateOf(Priority.Basic) }
    val taskDetails: TaskDetails = TaskDetails()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = { AddTaskTopBar(navigateBack = navigateBack) }) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(10.dp)) {
            Text(text = "Task")
            Spacer(modifier = Modifier.height(13.dp))
            AddEntryBody(addItemUiState = viewModel.addItemUiState ,
                         onTextChange = viewModel::updateUiState )
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                coroutineScope.launch {
                viewModel.saveTask()
            } },
                   modifier = Modifier.fillMaxWidth()) {
                Text(text = "Create Task")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskTopBar(navigateBack: () -> Unit, modifier: Modifier = Modifier){
    TopAppBar(
            title = { /*TODO*/ } ,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            navigationIcon = {
                // Image on the left
                Image(
                        imageVector = Icons.Outlined.KeyboardArrowLeft ,
                        contentDescription = null ,
                        contentScale = ContentScale.Crop ,
                        modifier = Modifier
                            .clickable { navigateBack() }
                            .clip(CircleShape)
                            .size(25.dp)
                )
            } ,
    )
}

@Composable
fun PriorityType(isSelected: Boolean, onClick: () -> Unit, priority: String, modifier: Modifier = Modifier) {
    Box(
            modifier = modifier
                .clickable { onClick() }
                .background(
                        color = if (isSelected) Color.Red else Color.White ,
                        shape = RoundedCornerShape(13.dp)
                ),
            contentAlignment = Alignment.Center
    ) {
        Text(
                text = priority,
                modifier = Modifier.padding(top = 5.dp, start = 12.dp, end = 12.dp, bottom = 5.dp),
                color = if (isSelected) Color.White else Color.Black
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEntryBody(
    addItemUiState: AddItemUiState,
    onTextChange: (TaskDetails) -> Unit
){
    Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
        OutlinedTextField(
                value = addItemUiState.taskDetails.taskTitle ,
                onValueChange = { onTextChange(addItemUiState.taskDetails.copy(taskTitle = it)) } ,
                singleLine = true ,
                label = { Text(text = "Add Title") } ,
                modifier = Modifier ,
        )

        OutlinedTextField(
                value = addItemUiState.taskDetails.taskDescription ,
                onValueChange = { onTextChange(addItemUiState.taskDetails.copy(taskDescription = it)) } ,
                singleLine = true ,
                label = { Text(text = "Add Description") } ,
                modifier = Modifier ,
        )
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputText(
    modifier: Modifier = Modifier ,
    text: String ,
    label: String ,
    onTextChange: (String) -> Unit ,
    singleLine: Boolean , ) {

    OutlinedTextField(
            value = text,
            onValueChange = { onTextChange(it) },
            singleLine = singleLine,
            label = { Text(text = label)},
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


