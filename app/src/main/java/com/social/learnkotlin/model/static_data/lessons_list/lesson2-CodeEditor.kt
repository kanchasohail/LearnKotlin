package com.social.learnkotlin.model.static_data.lessons_list

import com.social.learnkotlin.model.data_models.Lesson
import com.social.learnkotlin.model.data_models.LessonTopic
import com.social.learnkotlin.model.data_models.QuizModel

val lesson2_CodeEditor = Lesson(
    id = 2,
    lessonName = "Code Editor",
    lessonDescription = "An overview of what a code editor is",
    pagesCount = 3, lessonTopics = listOf(
        LessonTopic(
            topicId = 1,
            header = "Code Editor",
            article = listOf(
                "Congratulations for passing the first lesson of this amazing Kotlin tutorial.",
                "Before we move forward to the next lessons, we need to learn something about code editors and how it works.",
                "Code editor is simply a editor where we can edit our code.",
            ),
            codeExample = "null",
            codeOutPutExample = false,
            fact = "null",
            note = "null",
        ),
        LessonTopic(
            topicId = 2,
            header = "Some code editors -",
            article = listOf(
                "There are a lot of code editors out there, some of them are",
                "       • Vs Code",
                "       • InteliJ",
                "       • Vim",
                "       • Android Studio",
                "You don't need to remember them, we have our own code editor built in this app.",
                "So you do not need to worry if you do not have a pc or if you do not know how to use those code editors.",
                "Our built in code editor is enough to practice all the lessons and exercises that you are going to learn throughout this tutorial.",
                "Still, it is better to have some basic idea about how can we create a Kotlin file.",
                "The extension of Kotlin is '.kt' for example if we want to make a Kotlin file named first it will look something like this 'first.kt' .",
            ),
            codeExample = "",
            codeOutPutExample = false,
            fact = "",
            note = "",
        ),
        LessonTopic(
            topicId = 3,
            header = "Here are some steps to build a Kotlin file - ",
            article = listOf(
                "Step 1 - Open any code editor and click on the options buttons and select \"New File\" option.",
                "photo1",
                "Step 2 - Type the name of your file with '.kt' extension.",
                "photo2",
                "Step 3 - This is how the Kotlin file will look like",
                "photo3",
                "I hope you have learnt something about code editors, let's play the quiz.",
            ),
            codeExample = "",
            codeOutPutExample = false,
            fact = "",
            note = "We have inbuilt code editor in this app.",
        ),
    ),
    quiz = listOf(
        QuizModel(
            question = "What is Kotlin?",
            options = listOf(
                "Kotlin is a markup language",
                "Kotlin is a Programming language",
                "Kotlin is an assembly language"
            ),
            correctAnswer = "Kotlin is a Programming language"
        ),

        QuizModel(
            question = "Kotlin was developed by which company?",
            options = listOf("Bell Laboratories", "Google", "JetBrains"),
            correctAnswer = "JetBrains"
        ),
        QuizModel(
            question = "What is Kotlin mostly used for?",
            options = listOf(
                "Android apps development",
                "Web development",
                "Game development"
            ),
            correctAnswer = "Android apps development"
        ),
        QuizModel(
            question = "Before Kotlin which language was used for Android apps development?",
            options = listOf("JavaScript", "HTML/CSS", "Java"),
            correctAnswer = "Java"
        ),
    )
)