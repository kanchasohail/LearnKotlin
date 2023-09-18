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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.ui.layout.DefaultFontText
import com.social.learnkotlin.ui.layout.MyButton
import com.social.learnkotlin.ui.theme.cyanColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(lessonIndex: Int, navController: NavController , viewModel: QuizViewModel) {

    LaunchedEffect(key1 = lessonIndex) {
        viewModel.initializeQuizScreen(lessonIndex)
        viewModel.quizInitialSetup(viewModel.quiz)
    }

    val appBarContentColor = MaterialTheme.colorScheme.onBackground
    val secondaryColor = MaterialTheme.colorScheme.secondary
    val onSecondaryColor = MaterialTheme.colorScheme.onSecondary

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
                    .height(450.dp)
                    .fillMaxWidth()
                    .padding(8.dp), elevation = CardDefaults.cardElevation(
                    4.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    DefaultFontText(
                        text = "Question ${viewModel.quizQuestionIndex + 1} of ${viewModel.quiz.size}",
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    DefaultFontText(
                        text = viewModel.quiz[viewModel.quizQuestionIndex].question,
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    viewModel.quiz[viewModel.quizQuestionIndex].options.map {
                        OptionContainer(
                            modifier = Modifier.padding(vertical = 6.dp),
                            optionText = it,
                            isChecked = viewModel.currentSelectedAnswer == it
                        ) {
                            viewModel.selectOption(
                                selectedAnswer = it,
                                correctAnswer = viewModel.quiz[viewModel.quizQuestionIndex].correctAnswer
                            )
                        }
                    }

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
                            buttonColor = if (viewModel.isPreviousButtonActive) secondaryColor else Color.White,
                            buttonTextColor = if (viewModel.isPreviousButtonActive) onSecondaryColor else Color.Gray
                        ) {
                            viewModel.onPreviousClick()
                        }
                        if (!viewModel.isLastQuestion) {
                            MyButton(
                                buttonText = "Next",
                                modifier = Modifier.fillMaxWidth(0.8f),
                                buttonColor = if (viewModel.isAnswered) MaterialTheme.colorScheme.primary else Color.Gray
                            ) {
                                if (viewModel.isAnswered) {
                                    viewModel.onNextClick()
                                }
                            }
                        } else {
                            MyButton(
                                buttonText = "Submit",
                                modifier = Modifier.fillMaxWidth(0.8f),
                                buttonColor = if (viewModel.isAnswered) cyanColor else Color.Gray,
                                buttonTextColor = Color.Black
                            ) {
                                if (viewModel.isAnswered) {
                                    navController.navigate(Screens.QuizResultScreen.route)
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}