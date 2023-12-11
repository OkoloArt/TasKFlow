package com.example.taskflow.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskflow.R
import com.example.taskflow.ui.commonUI.AnimatedCircularProgressIndicator
import com.example.taskflow.ui.theme.LightPurple
import com.example.taskflow.ui.theme.LightSkyBlue
import com.example.taskflow.ui.theme.Purple40
import com.example.taskflow.ui.theme.Purple80
import com.example.taskflow.ui.theme.PurpleGrey40


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navigateToAddTask: () -> Unit, navigateToDetails: () -> Unit){

    Scaffold(
            topBar = { HomeScreenTopBar(navigateToAddTask)}
    ) { innerPadding ->

        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(start = 10.dp , end = 10.dp , top = 10.dp)
            .fillMaxSize()){

            IntroText(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 4.dp)
                ) {
                    StatsItemCard(
                            color = LightPurple,
                            cardTitle = "Task Today",
                            annotatedString = "8",
                            modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 4.dp)
                ) {
                    StatsItemCard(
                            color = LightSkyBlue ,
                            cardTitle = "In Progress" ,
                            annotatedString = "4" ,
                            modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            TaskItemList(onItemClick = navigateToDetails )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar(navigateToAddTask : () -> Unit){
    TopAppBar(title = {} ,
              navigationIcon = {
                  // Image on the left
                  Image(
                          painter = painterResource(id = R.drawable.husky) ,
                          contentDescription = null ,
                          contentScale = ContentScale.Crop ,
                          modifier = Modifier
                              .clip(CircleShape)
                              .size(40.dp)
                  )
              } ,
              actions = {
                  // Icons on the right
                  Row {
                      Box(
                              modifier = Modifier
                                  .size(40.dp)
                                  .background(Color.White , shape = CircleShape)
                                  .clickable { navigateToAddTask() },
                              contentAlignment = Alignment.Center
                      ) {
                          Icon(
                                  imageVector = Icons.Outlined.Add ,
                                  contentDescription = null ,
                                  modifier = Modifier
                                      .size(20.dp)
                          )
                      }
                      Spacer(modifier = Modifier.width(8.dp))
                      Box(
                              modifier = Modifier
                                  .size(40.dp)
                                  .background(Color.White , shape = CircleShape) ,
                              contentAlignment = Alignment.Center
                      ) {
                          Icon(
                                  imageVector = Icons.Outlined.Notifications ,
                                  contentDescription = null ,
                                  modifier = Modifier
                                      .size(20.dp)
                          )
                      }
                  }
              }
    )
}

@Composable
fun StatsItemCard(color: Color ,
                  cardTitle: String ,
                  annotatedString: String , modifier: Modifier = Modifier){
    Card (shape = RoundedCornerShape(10.dp)) {
        Column(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()) {
            Box(modifier = Modifier
                .padding(4.dp)
                .size(40.dp)
                .background(color = color , shape = CircleShape),
                contentAlignment = Alignment.Center) {
                // Icon with reduced size
                Icon(
                        imageVector = Icons.Outlined.DateRange,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = cardTitle)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)) {
                    append(annotatedString)
                }
                append(" Tasks")
            } )
        }
    }
}

@Composable
fun IntroText(modifier: Modifier){
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 16.sp, fontFamily = FontFamily.Serif)) {
                append("Hello,")
            }
            withStyle(style = SpanStyle(fontSize = 17.sp, fontWeight = FontWeight.SemiBold)) {
                append(" Jane")
            }
        } )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 16.sp, fontFamily = FontFamily.Serif)) {
                append("You have")
            }
            withStyle(style = SpanStyle(fontSize = 17.sp, fontWeight = FontWeight.SemiBold)) {
                append(" 6 Tasks")
            }
            withStyle(style = SpanStyle(fontSize = 16.sp, fontFamily = FontFamily.Serif)) {
                append(" to complete")
            }
        } )
    }
}

@Composable
fun TaskItemCard(onClick: () -> Unit, modifier: Modifier = Modifier){
    Card(modifier = modifier.fillMaxWidth()
        .clickable { onClick() },
         shape = RoundedCornerShape(25.dp)) {
        Column(modifier = Modifier.padding(10.dp, bottom = 12.dp, top = 12.dp)) {
            Row(modifier = Modifier.fillMaxWidth().padding(end = 10.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {

                    Text(text = "3D Character Cute Robot",
                         fontSize = 22.sp,)

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(text = "There are 3 Unfinished Tasks",
                         fontSize = 13.sp,)

                    Spacer(modifier = Modifier.height(10.dp))
                }
                Spacer(modifier = Modifier.width(8.dp))
                AnimatedCircularProgressIndicator(
                        currentValue = 17,
                        maxValue = 20,
                        progressBackgroundColor = Purple80,
                        progressIndicatorColor = PurpleGrey40,
                        completedColor = Purple40,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .size(55.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                CustomBox(color = Color.Red) {
                    Text(text = "Important", modifier = it,
                         color = Color.White,
                         fontSize = 13.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                CustomBox(color = LightPurple){
                    Text(text = "16 Oct 2023", modifier = it,
                         color = Color.White,
                         fontSize = 13.sp)
                }
            }
        }
    }
}

@Composable
fun CustomBox(color: Color, content: @Composable (Modifier) -> Unit) {
    Box(
            modifier = Modifier
                .background(color = color, shape = RoundedCornerShape(13.dp)),
            contentAlignment = Alignment.Center
    ) {
        content(Modifier.padding(top = 5.dp, start = 12.dp, end = 12.dp, bottom = 5.dp))
    }
}

@Composable
fun DateItemCard(modifier: Modifier = Modifier) {
    Card(
            modifier = modifier ,
    ) {
        Column(
                modifier = Modifier.padding(10.dp) ,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Wed")
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "17")
        }
    }
}

@Composable
fun TaskItemList(onItemClick : () -> Unit, modifier: Modifier = Modifier){

    Column {
        Text(text = "Your Task",
             fontSize = 18.sp,
             fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(18.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(9) {
                DateItemCard()
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(14.dp)) {
            items(2) {
                TaskItemCard(onClick = onItemClick)
            }
        }
    }

}

