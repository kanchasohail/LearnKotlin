package com.social.learnkotlin.model.static_data.lessons_list

import com.social.learnkotlin.model.data_models.Lesson
import com.social.learnkotlin.model.data_models.LessonTopic

val lesson1_KotlinIntroduction = Lesson(
    id = 1,
    lessonName = "Kotlin Introduction",
    lessonDescription = "This is a small overview about kotlin",
    lessonTopics = listOf(
        LessonTopic(
            lessonId = 1,
            topicId = 1,
            header = "What is Kotlin?",
            article = listOf(
                "Kotlin is a modern, trending programming language.",
                "Kotlin is a relatively new programming language developed by JetBrains.",
                "Nowadays, Kotlin is widely used for Android apps development instead of Java. It is because Kotlin is safe, concise, and fun to read and write.",
            ),
            codeExample = "null",
            codeOutPutExample = false,
            fact = "null",
            note = "null",
        ),
        LessonTopic(
            lessonId = 1,
            topicId = 2,
            header = "About the tutorial -",
            article = listOf(
                "Our Kotlin tutorial will guide you to learn Kotlin step by step from scratch. Even if you do not have any knowledge about programming.",
                "In this tutorial you will learn Kotlin with many interesting lessons, quizes and challenges. So, own your marks and let's go.",
                "Here is an example of basic \"Hello World\" program in Kotlin:",
            ),
            codeExample = """fun main() {
    println("Hello world")
}""",
            codeOutPutExample = true,
            fact = "",
            note = "You can click on that \\\"try it yourself\\\" button to open the editor and edit the code.",
        ),
        LessonTopic(
            lessonId = 1,
            topicId = 3,
            header = "Why should we learn Kotlin?",
            article = listOf(
                "Kotlin is easy to learn, especially if you already know Java (it is 100% compatible with Java). But even if you don't know Java this tutorial is going to teach you everything from scratch.",
                "Kotlin is used to develop Android apps, server side apps, and much more. But it is mostly used to develop Android apps.",
                "We will learn more about Kotlin in next upcoming lessons. Before that let's see how much we learnt from this lesson (click on the Start Quiz button).",
            ),
            codeExample = "",
            codeOutPutExample = false,
            fact = "",
            note = "",
        ),
    )
)