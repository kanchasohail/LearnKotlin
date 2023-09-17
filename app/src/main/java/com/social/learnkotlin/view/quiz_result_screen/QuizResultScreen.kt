package com.social.learnkotlin.view.quiz_result_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.social.learnkotlin.ui.layout.DefaultFontText
import com.social.learnkotlin.view.quiz_screen.QuizViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizResultScreen(navController: NavController) {

    val answers = listOf(
        QuizViewModel.PlayedQuizModel(
            "what is your name",
            "sohail",
            true
        ),
        QuizViewModel.PlayedQuizModel(
            "what is your name",
            "sohail",
            false
        ),
        QuizViewModel.PlayedQuizModel(
            "What is your name",
            "sohail",
            true
        ),
        QuizViewModel.PlayedQuizModel(
            "what is your name",
            "sohail",
            false
        ),
        QuizViewModel.PlayedQuizModel(
            "what is your name",
            "sohail",
            true
        ),
    )

    val appBarContentColor = MaterialTheme.colorScheme.onBackground
    val secondaryColor = MaterialTheme.colorScheme.secondary
    val onSecondaryColor = MaterialTheme.colorScheme.onSecondary

    Scaffold(topBar = {
        TopAppBar(title = {
            DefaultFontText(
                text = "Quiz Result",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "close",
                        modifier = Modifier.size(35.dp)
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "close",
                        modifier = Modifier.size(35.dp),
                        tint = Color.Transparent
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                titleContentColor = appBarContentColor,
                actionIconContentColor = appBarContentColor,
                navigationIconContentColor = appBarContentColor
            ),
            modifier = Modifier.shadow(6.dp)
        )
    }) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(){
                items(answers.size){
                    ResultContainer(playedQuiz = answers[it] , modifier = Modifier.padding(8.dp))
                }
            }
            
        }

    }
}