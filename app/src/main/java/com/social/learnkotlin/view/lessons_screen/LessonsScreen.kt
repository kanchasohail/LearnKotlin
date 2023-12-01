package com.social.learnkotlin.view.lessons_screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.social.learnkotlin.model.static_data.AllLessons
import com.social.learnkotlin.navigation.PressBackAgainToExit
import com.social.learnkotlin.navigation.Screens

@Composable
fun LessonsScreen(navController: NavController) {
    val lazyListState = rememberLazyListState()
    val context = LocalContext.current

    val onGoingLessonIndexKey = "on_going_lesson_index"
    val prefs by lazy {
        context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }

    val onGoingLessonIndex = prefs.getInt(onGoingLessonIndexKey, 0)

    PressBackAgainToExit()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        state = lazyListState
    ) {
        items(AllLessons.lessonsList.size) { index: Int ->
            val thisLesson = AllLessons.lessonsList[index]
            LessonCard(
                lessonName = thisLesson.lessonName,
                descriptionText = thisLesson.lessonDescription,
                pagesCount = thisLesson.pagesCount,
                isOnGoing = onGoingLessonIndex == index,
                isCompleted = onGoingLessonIndex > index,
                onClick = {
                    if (index > onGoingLessonIndex) {
                        Toast.makeText(
                            context,
                            "Please complete the previous lessons!` ",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        navController.navigate(Screens.ReadingScreen.withArgs(index.toString()))
                    }
                },
            )
        }

    }

    LaunchedEffect(onGoingLessonIndex) {
        lazyListState.animateScrollToItem(if (onGoingLessonIndex == 0) onGoingLessonIndex else onGoingLessonIndex - 1)
    }

}