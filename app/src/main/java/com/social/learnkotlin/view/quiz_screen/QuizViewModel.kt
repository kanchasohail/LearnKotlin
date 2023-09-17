package com.social.learnkotlin.view.quiz_screen

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.social.learnkotlin.model.data_models.QuizModel
import com.social.learnkotlin.model.static_data.AllLessons

class QuizViewModel(lessonIndex: Int) : ViewModel() {

    private val thisLesson = AllLessons.lessonsList[lessonIndex]

    val lessonTitle = thisLesson.lessonName

    val quiz = thisLesson.quiz

    var quizQuestionIndex by mutableIntStateOf(0)

    var currentSelectedAnswer by mutableStateOf("")

    data class PlayedQuizModel(
        val question: String,
        var selectedAnswer: String,
        var isCorrect: Boolean
    )

    var playedQuiz = listOf<PlayedQuizModel>()

    val isPreviousButtonActive by
    derivedStateOf { quizQuestionIndex > 0 }

    var isAnswered by mutableStateOf(false)

    val isLastQuestion by derivedStateOf {
        quiz.size == quizQuestionIndex + 1
    }


    //This method is for initial quizSetup
    fun quizInitialSetup(quiz: List<QuizModel>) {
        playedQuiz = quiz.map {
            PlayedQuizModel(
                question = it.question,
                selectedAnswer = "",
                isCorrect = false
            )
        }.toList()
    }

    //This method is for selecting any option
    fun selectOption(
        selectedAnswer: String,
        correctAnswer: String
    ) {
        currentSelectedAnswer = selectedAnswer
        playedQuiz[quizQuestionIndex].selectedAnswer = selectedAnswer
        playedQuiz[quizQuestionIndex].isCorrect = selectedAnswer == correctAnswer

        isAnswered = playedQuiz[quizQuestionIndex].selectedAnswer != ""
    }

    fun onNextClick() {
        if (quiz.size - 1 > quizQuestionIndex) {
            quizQuestionIndex++

            if (playedQuiz[quizQuestionIndex].selectedAnswer != "") {
                currentSelectedAnswer =
                    playedQuiz[quizQuestionIndex].selectedAnswer
            }
            isAnswered = playedQuiz[quizQuestionIndex].selectedAnswer != ""
        }
    }

    fun onPreviousClick() {
        if (quizQuestionIndex > 0) {
            quizQuestionIndex--

            if (playedQuiz[quizQuestionIndex].selectedAnswer != "") {
                currentSelectedAnswer =
                    playedQuiz[quizQuestionIndex].selectedAnswer
            }
            isAnswered = playedQuiz[quizQuestionIndex].selectedAnswer != ""
        }
    }

}