package com.example.taskflow.ui.screens

import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskflow.R


@Composable
fun TaskDetailScreen() {
}

@Composable
fun TopBar(){
    Box(modifier = Modifier.fillMaxWidth()) {
        Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(40.dp)
                    .background(color = Color.White , shape = CircleShape) ,
                contentAlignment = Alignment.Center
        ) {
            Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft ,
                    contentDescription = null ,
                    modifier = Modifier.size(20.dp)
            )
        }
        IconAndText(modifier = Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
fun IconAndText(modifier: Modifier = Modifier) {
    Row(
            verticalAlignment = Alignment.CenterVertically ,
            modifier = modifier
                .background(color = Color.White , shape = RoundedCornerShape(15.dp))

    ) {
        Icon(
                imageVector = Icons.Outlined.Edit ,
                contentDescription = null ,
                modifier = Modifier.padding(8.dp) // Add padding to the Icon
        )
        Text(
                text = "Edit Task" ,
                modifier = Modifier.padding(top = 8.dp, end = 8.dp, bottom = 8.dp) // Add padding to the Text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskDetail(modifier: Modifier = Modifier){
    val animatedProgress by animateFloatAsState(
            targetValue = 0.5f ,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec ,
            label = ""
    )
    Column(modifier = modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .background(color = Color.Red, shape = RoundedCornerShape(13.dp)),
            contentAlignment = Alignment.Center) {
            Text(text = "Important",
                 modifier = Modifier.padding(top = 5.dp, start = 12.dp, end = 12.dp, bottom = 5.dp))
        }
        Text(text = "3d Character Cute Robot")
        Row {
            ImageAndTextCard(textTitle = "Created" , textValue = "Smith" , modifier.weight(1f))
            ImageAndTextCard(textTitle = "Date Due" , textValue = "16th Oct 2023" , modifier.weight(1f))
        }
        Text(text = "Description")
        Text(text = "Create a 3d character using blender, the style used is simple and cute and uses soft colors")
        LinearProgressIndicator(
                progress = 0.2f ,
                color = Color.Green ,
                modifier = Modifier
                    .height(8.dp)
                    .clip(RoundedCornerShape(16.dp)) ,
                trackColor = Color.Green
        )
        Text(text = "SubTasks")
        SubTasks()
    }
}

@Composable
fun ImageAndTextCard(textTitle: String, textValue: String, modifier: Modifier = Modifier){
    Row(modifier = modifier.fillMaxWidth()) {
        Image(painter = painterResource(id = R.drawable.husky) ,
              contentDescription = null,
              contentScale = ContentScale.Crop,
              modifier = Modifier
                  .padding(start = 8.dp , top = 8.dp , bottom = 8.dp)
                  .clip(CircleShape)
                  .size(50.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 8.dp)) {
            Text(text = textTitle)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = textValue,
                 fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun SubTasks(modifier: Modifier= Modifier){
    val taskList = listOf("Task 1", "Task 2", "Task 3", "Task 4", "Task 5")
    LazyColumn() {
        items(taskList.size) {
            SubTaskItem(
                    subTaskTitle = taskList[it],
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun SubTaskItemButton(
    expand: Boolean,
    onClick : () -> Unit,
    modifier: Modifier = Modifier){
    IconButton(onClick =  onClick, modifier = modifier) {
        Icon(imageVector = if (expand) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown ,
             contentDescription = null ,
             tint = MaterialTheme.colorScheme.secondary )
    }
}

@Composable
fun SubTaskDetails(
    subTask: String ,
    modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        Text(text = subTask,
             style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun SubTaskInfo(subTaskTitle: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
                text = subTaskTitle,
                modifier = Modifier.padding(6.dp)
        )
    }
}

@Composable
fun SubTaskItem(subTaskTitle: String, modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }
    val (checkedState, onStateChange) = remember { mutableStateOf(false) }
    val color by animateColorAsState(
            targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
            else MaterialTheme.colorScheme.primaryContainer ,
            label = "" ,
    )

    Card(modifier = modifier) {
        Column(modifier = Modifier
            .animateContentSize(
                    animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy ,
                            stiffness = Spring.StiffnessMedium
                    )
            )
            .background(color = color)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))) {
                Box(Modifier.align(alignment = Alignment.CenterVertically)
                        .toggleable(
                        value = checkedState,
                        onValueChange = { onStateChange(!checkedState) },
                        role = Role.Checkbox
                )) {
                    Checkbox(
                            checked = checkedState ,
                            onCheckedChange = null
                    )
                }
                SubTaskInfo(subTaskTitle, modifier.align(alignment = Alignment.CenterVertically))
                Spacer(modifier = Modifier.weight(1f))
                SubTaskItemButton(expand = expanded , onClick = { expanded = !expanded })
            }
            if (expanded){
                SubTaskDetails(subTask = stringResource(id = R.string.dummy_text), modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium))
                )
            }

        }
    }
}

