package com.social.learnkotlin.model.data_models

data class LessonTopic(
    val topicId: Int,
    val header: String?,
    val article: List<String>,
    val codeExample: String?,
    val codeOutPutExample: Boolean,
    val fact: String?,
    val note: String?,
)
