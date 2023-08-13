package com.social.learnkotlin.view.lessons_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LessonsScreenViewModel : ViewModel() {


    var onGoingLessonIndex by mutableIntStateOf(4)

}