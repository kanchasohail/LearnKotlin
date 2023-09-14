package com.social.learnkotlin.model.data_models

data class Lesson(
    val id: Int,
    val lessonName: String,
    val lessonDescription: String,
    val pagesCount: Int,
    val lessonTopics: List<LessonTopic>
)