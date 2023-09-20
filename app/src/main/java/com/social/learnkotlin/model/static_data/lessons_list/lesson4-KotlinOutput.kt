package com.social.learnkotlin.model.static_data.lessons_list

import com.social.learnkotlin.model.data_models.Lesson
import com.social.learnkotlin.model.data_models.LessonTopic
import com.social.learnkotlin.model.data_models.QuizModel

val lesson4_KotlinOutput = Lesson(
    id = 4,
    lessonName = "Kotlin Output",
    lessonDescription = "All about kotlin output",
    pagesCount = 3, lessonTopics = listOf(
        LessonTopic(
            topicId = 1,
            header = "IWhat is Kotlin?",
            article = listOf(
                "Kotlin is a modern, trending programming language.",
                "Kotlin is a relatively new programming language developed by JetBrains.",
                "Nowadays, Kotlin is widely used for Android apps development instead of Java. It is because Kotlin is safe, concise, and fun to read and write.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
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
            fact = null,
            note = "You can click on that \\\"try it yourself\\\" button to open the editor and edit the code.",
        ),
        LessonTopic(
            topicId = 3,
            header = "Why should we learn Kotlin?",
            article = listOf(
                "Kotlin is easy to learn, especially if you already know Java (it is 100% compatible with Java). But even if you don't know Java this tutorial is going to teach you everything from scratch.",
                "Kotlin is used to develop Android apps, server side apps, and much more. But it is mostly used to develop Android apps.",
                "We will learn more about Kotlin in next upcoming lessons. Before that let's see how much we learnt from this lesson (click on this play quiz button).",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note= null,
        ),
    ),
    quiz = listOf(
        QuizModel(
            question = "What does output mean is Kotlin?",
            options = listOf("Play music", "Display Images", "Print something on screen" ),
            correctAnswer = "Print something on screen"
        ),

        QuizModel(
            question = "What do we use to out text/values in Kotlin?",
            options = listOf("print()", "println()", "Both"),
            correctAnswer = "Both"
        ),
        QuizModel(
            question = "Which function adds a new line after output?",
            options = listOf("println()", "print()", "both"),
            correctAnswer = "println()"
        ),
        QuizModel(
            question = "Which function doesn't add a new line after output?",
            options = listOf("print()", "println() ", "Both"),
            correctAnswer = "print()"
        ),
        QuizModel(
            question = "How many print functions can we add in a Kotlin program?",
            options = listOf("Less than 100", "More than 100", "As many as needed"),
            correctAnswer = "As many as needed"
        ),
    )
)