package com.social.learnkotlin.view.quiz_result_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.social.learnkotlin.ui.layout.DefaultFontText
import com.social.learnkotlin.ui.layout.MyButton
import com.social.learnkotlin.view.quiz_screen.QuizViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizResultScreen(navController: NavController, viewModel: QuizViewModel) {

    val context = LocalContext.current

    val appBarContentColor = MaterialTheme.colorScheme.onBackground

    Scaffold(topBar = {
        TopAppBar(
            title = {
                DefaultFontText(
                    text = "Quiz Result",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                    navController.popBackStack()
                }) {
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
    }, bottomBar = {
        BottomAppBar(
            modifier = Modifier
                .height(70.dp)
        ) {
            if (viewModel.getCorrectAnswersCount() == viewModel.playedQuiz.size) {
                MyButton(
                    buttonText = "Next Lesson",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    viewModel.passThisLesson(context , navController)
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    MyButton(buttonText = "Retake Lesson", modifier = Modifier.fillMaxWidth(0.4f)) {
                        navController.popBackStack()
                        navController.popBackStack()
                    }
                    MyButton(buttonText = "Retake Quiz", modifier = Modifier.fillMaxWidth(0.62f)) {
                        viewModel.quizQuestionIndex = 0
                        navController.popBackStack()
                    }
                }
            }
        }

    }) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Spacer(modifier = Modifier.height(5.dp))
                    DefaultFontText(
                        text = viewModel.getResultText(),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    DefaultFontText(
                        text = "You've got ${viewModel.getCorrectAnswersCount()} out of ${viewModel.playedQuiz.size} questions correct.",
                        fontSize = 18.sp
                    )
                }
                LazyColumn() {
                    items(viewModel.playedQuiz.size) {
                        ResultContainer(
                            playedQuiz = viewModel.playedQuiz[it],
                            questionNo = it + 1,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}