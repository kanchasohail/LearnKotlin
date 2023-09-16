package com.social.learnkotlin.view.quiz_screen

import androidx.lifecycle.ViewModel
import com.social.learnkotlin.model.static_data.AllLessons

class QuizViewModel : ViewModel() {

    var lessonIndex: Int = 0

    val lessonTitle = AllLessons.lessonsList[lessonIndex].lessonName

}