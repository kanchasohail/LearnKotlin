package com.social.learnkotlin.model.data_models

data class QuizModel(
    val question: String,
    val options: List<String>,
    val correctAnswer: String,
)
