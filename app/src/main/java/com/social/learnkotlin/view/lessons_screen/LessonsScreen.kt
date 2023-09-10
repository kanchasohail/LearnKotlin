package com.social.learnkotlin.view.lessons_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.social.learnkotlin.model.static_data.AllLessons
import com.social.learnkotlin.navigation.PressBackAgainToExit
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.ui.layout.scaffoldGradientBg

@Composable
fun LessonsScreen(navController: NavController) {
    val viewModel = viewModel<LessonsScreenViewModel>()
    val lazyListState = rememberLazyListState()
    val onGoingLessonIndex = viewModel.onGoingLessonIndex
    val context = LocalContext.current

    PressBackAgainToExit()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                scaffoldGradientBg()
            ),
        state = lazyListState
    ) {
        items(AllLessons.lessonsList.size) { index: Int ->
            val name = AllLessons.lessonsList[index]
            LessonCard(
                lessonName = name,
                descriptionText = name,
                pagesCount = index,
                isOnGoing = onGoingLessonIndex == index,
                isCompleted = onGoingLessonIndex > index,
                modifier = Modifier.clickable {
                    if (index > onGoingLessonIndex) {
                        Toast.makeText(
                            context,
                            "Please complete the previous lessons!` ",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        navController.navigate(Screens.ReadingScreen.withArgs(index.toString()))
                    }
                }
            )
        }

    }

    LaunchedEffect(onGoingLessonIndex) {
        lazyListState.animateScrollToItem(onGoingLessonIndex - 1)
    }

}