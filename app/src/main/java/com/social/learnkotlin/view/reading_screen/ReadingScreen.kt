package com.social.learnkotlin.view.reading_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.social.learnkotlin.model.static_data.AllLessons
import com.social.learnkotlin.ui.layout.DefaultFontText
import com.social.learnkotlin.ui.layout.MyButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadingScreen(navController: NavController, lessonIndex: Int?) {
    val context = LocalContext.current

    val viewModel = viewModel<ReadingScreenViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ReadingScreenViewModel(
                    context = context,
                    onGoingLessonId = lessonIndex ?: 0
                ) as T
            }
        }
    )

    val thisLesson = AllLessons.lessonsList[lessonIndex ?: 0]

    val appBarContentColor = MaterialTheme.colorScheme.onBackground

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
                title = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, end = 12.dp)
                    ) {
                        DefaultFontText(
                            text = thisLesson,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        LessonsCountBar(
                            dashCount = viewModel.totalTopics,
                            completedLessons = viewModel.completedTopics,
                            modifier = Modifier.height(12.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = "Back",
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
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(70.dp)
            ) {
                BottomButtons {
                    viewModel.onNextClick()
                }
            }
        }
    ) { paddingValues ->
        val scrollState = rememberScrollState(
            initial = viewModel.initialScrollPosition
        )

        LaunchedEffect(scrollState) {
            viewModel.saveScrollPosition(scrollState)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ReadingCard(modifier = Modifier.padding(10.dp))
        }

    }
}

@Composable
private fun LessonsCountBar(
    modifier: Modifier = Modifier,
    dashCount: Int,
    completedLessons: Int,
    strokeWidth: Float = 8f
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Row(modifier = modifier.fillMaxWidth(0.8f)) {

        val totalLength = (dashCount * 2 - 1).toFloat()

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val startY = size.height / 2f
            val endX = size.width
            var currentX = 0f
            var currentBarNo = 1

            while (currentX < endX) {
                drawLine(
                    color = if (currentBarNo <= completedLessons) primaryColor else Color.Black,
                    start = Offset(currentX, startY),
                    end = Offset(currentX + (size.width / totalLength), startY),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
                currentX += (size.width / totalLength) * 2
                currentBarNo++
            }
        }
    }
}


@Composable
private fun BottomButtons(onNextClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp)
    ) {

        MyButton(
            buttonText = "Ask a question",
            modifier = Modifier.fillMaxWidth(0.6f),
            buttonColor = Color.White,
            buttonTextColor = Color.Gray
        ) {

        }


        MyButton(buttonText = "Next", modifier = Modifier.fillMaxWidth(0.8f)) {
            onNextClick()
        }

    }
}