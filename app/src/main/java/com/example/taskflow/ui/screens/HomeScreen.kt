package com.example.taskflow.ui.screens

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
import com.example.taskflow.ui.theme.LightPurple
import com.example.taskflow.ui.theme.LightSkyBlue

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

    Scaffold(
            topBar = { HomeScreenTopBar()}
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
                    StatsCard(
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
                    StatsCard(
                            color = LightSkyBlue ,
                            cardTitle = "In Progress" ,
                            annotatedString = "4" ,
                            modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar(){
    TopAppBar(title = {},
            navigationIcon = {
        // Image on the left
                Image(
                        painter = painterResource(id = R.drawable.husky) ,
                        contentDescription = null ,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp)
                )
            } ,
              actions = {
                  // Icons on the right
                  Row {
                      Box(modifier = Modifier
                          .size(40.dp)
                          .background(Color.White , shape = CircleShape),
                          contentAlignment = Alignment.Center) {
                          Icon(
                                  imageVector = Icons.Outlined.Add ,
                                  contentDescription = null ,
                                  modifier = Modifier
                                      .size(20.dp)
                          )
                      }
                      Spacer(modifier = Modifier.width(8.dp))
                      Box(modifier = Modifier
                          .size(40.dp)
                          .background(Color.White , shape = CircleShape),
                          contentAlignment = Alignment.Center) {
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
fun StatsCard(color: Color, cardTitle: String, annotatedString: String, modifier: Modifier = Modifier){
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
