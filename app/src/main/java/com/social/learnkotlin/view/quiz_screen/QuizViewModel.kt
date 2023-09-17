package com.social.learnkotlin.view.quiz_screen

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.social.learnkotlin.model.static_data.AllLessons

class QuizViewModel(lessonIndex: Int) : ViewModel() {

    private val thisLesson = AllLessons.lessonsList[lessonIndex]

    val lessonTitle = thisLesson.lessonName

    val quiz = thisLesson.quiz

    var quizQuestionIndex by mutableIntStateOf(0)


    val isPreviousButtonActive by
    derivedStateOf { quizQuestionIndex > 0 }


    fun onNextClick() {
        if (quiz.size - 1 > quizQuestionIndex) {
            quizQuestionIndex++
        }
    }

    fun onPreviousClick() {
        if (quizQuestionIndex > 0) {
            quizQuestionIndex--
        }
    }

}