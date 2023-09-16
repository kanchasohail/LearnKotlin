package com.social.learnkotlin.view.quiz_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.social.learnkotlin.ui.layout.DefaultFontText
import com.social.learnkotlin.ui.layout.MyButton

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
//fun QuizScreen(lessonIndex: Int) {
fun QuizScreen(lessonIndex: Int = 2) {
    val viewModel = viewModel<QuizViewModel>()
    viewModel.lessonIndex = lessonIndex

    val appBarContentColor = MaterialTheme.colorScheme.onBackground

    Scaffold(
        topBar = {
            TopAppBar(title = {
                DefaultFontText(
                    text = viewModel.lessonTitle,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }, navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "close",
                        modifier = Modifier.size(35.dp)
                    )
                }
            }, actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "close",
                        modifier = Modifier.size(35.dp),
                        tint = Color.Transparent
                    )
                }
            }, colors = TopAppBarDefaults.smallTopAppBarColors(
                titleContentColor = appBarContentColor,
                actionIconContentColor = appBarContentColor,
                navigationIconContentColor = appBarContentColor
            ),
                modifier = Modifier.shadow(6.dp)
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(6.dp)
        ) {
            Card(
                modifier = Modifier
                    .height(420.dp)
                    .fillMaxWidth()
                    .padding(8.dp), elevation = CardDefaults.cardElevation(
                    4.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                ) {
                    DefaultFontText(text = "Question 1 of 5", fontSize = 18.sp)

                    Spacer(modifier = Modifier.height(20.dp))

                    DefaultFontText(
                        text = "Which version of HTML is currently in use?",
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OptionContainer(modifier = Modifier.padding(vertical = 6.dp))
                    OptionContainer(modifier = Modifier.padding(vertical = 6.dp))
                    OptionContainer(modifier = Modifier.padding(vertical = 6.dp))

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        MyButton(
                            buttonText = "Previous",
                            modifier = Modifier.fillMaxWidth(0.45f),
                        ) {

                        }
                        MyButton(
                            buttonText = "Next",
                            modifier = Modifier.fillMaxWidth(0.8f),
                        ) {

                        }
                    }

                }
            }
        }

    }
}