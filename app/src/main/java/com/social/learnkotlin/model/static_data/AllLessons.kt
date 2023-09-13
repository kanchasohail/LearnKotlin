package com.social.learnkotlin.model.static_data

import com.social.learnkotlin.model.data_models.Lesson
import com.social.learnkotlin.model.data_models.LessonTopic

object AllLessons {
    val lessonsList = listOf(
        //First Lesson(Kotlin Introduction)
        Lesson(
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
        ),


        //Second Lesson(Code Editor)
        Lesson(
            id = 2,
            lessonName = "Code Editor",
            lessonDescription = "An overview of what a code editor is",
            lessonTopics = listOf(
                LessonTopic(
                    lessonId = 1,
                    topicId = 1,
                    header = "IWhat is Kotlin?",
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
                        "We will learn more about Kotlin in next upcoming lessons. Before that let's see how much we learnt from this lesson (click on this play quiz button).",
                    ),
                    codeExample = "",
                    codeOutPutExample = false,
                    fact = "",
                    note = "",
                ),
            )
        ),
        Lesson(
            id = 3,
            lessonName = "Kotlin Syntax",
            lessonDescription = "Quick Introduction to Kotlin syntax",
            lessonTopics = listOf(
                LessonTopic(
                    lessonId = 1,
                    topicId = 1,
                    header = "IWhat is Kotlin?",
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
                        "We will learn more about Kotlin in next upcoming lessons. Before that let's see how much we learnt from this lesson (click on this play quiz button).",
                    ),
                    codeExample = "",
                    codeOutPutExample = false,
                    fact = "",
                    note = "",
                ),
            )
        ),
        Lesson(
            id = 4,
            lessonName = "Kotlin Output",
            lessonDescription = "All about kotlin output",
            lessonTopics = listOf(
                LessonTopic(
                    lessonId = 1,
                    topicId = 1,
                    header = "IWhat is Kotlin?",
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
                        "We will learn more about Kotlin in next upcoming lessons. Before that let's see how much we learnt from this lesson (click on this play quiz button).",
                    ),
                    codeExample = "",
                    codeOutPutExample = false,
                    fact = "",
                    note = "",
                ),
            )
        ),
        Lesson(
            id = 5,
            lessonName = "Kotlin Comments",
            lessonDescription = "Kotlin comments and their use cases",
            lessonTopics = listOf(
                LessonTopic(
                    lessonId = 1,
                    topicId = 1,
                    header = "IWhat is Kotlin?",
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
                        "We will learn more about Kotlin in next upcoming lessons. Before that let's see how much we learnt from this lesson (click on this play quiz button).",
                    ),
                    codeExample = "",
                    codeOutPutExample = false,
                    fact = "",
                    note = "",
                ),
            )
        ),
        Lesson(
            id = 6,
            lessonName = "Kotlin Variables",
            lessonDescription = "Kotlin variables and their use",
            lessonTopics = listOf(
                LessonTopic(
                    lessonId = 1,
                    topicId = 1,
                    header = "IWhat is Kotlin?",
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
                        "We will learn more about Kotlin in next upcoming lessons. Before that let's see how much we learnt from this lesson (click on this play quiz button).",
                    ),
                    codeExample = "",
                    codeOutPutExample = false,
                    fact = "",
                    note = "",
                ),
            )
        ),
        Lesson(
            id = 7,
            lessonName = "Kotlin var and val",
            lessonDescription = "Difference between var and val and their use cases",
            lessonTopics = listOf(
                LessonTopic(
                    lessonId = 1,
                    topicId = 1,
                    header = "IWhat is Kotlin?",
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
                        "We will learn more about Kotlin in next upcoming lessons. Before that let's see how much we learnt from this lesson (click on this play quiz button).",
                    ),
                    codeExample = "",
                    codeOutPutExample = false,
                    fact = "",
                    note = "",
                ),
            )
        ),
        Lesson(
            id = 8,
            lessonName = "Display Variables",
            lessonDescription = "Let's learn how to display variables",
            lessonTopics = listOf(
                LessonTopic(
                    lessonId = 1,
                    topicId = 1,
                    header = "IWhat is Kotlin?",
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
                        "We will learn more about Kotlin in next upcoming lessons. Before that let's see how much we learnt from this lesson (click on this play quiz button).",
                    ),
                    codeExample = "",
                    codeOutPutExample = false,
                    fact = "",
                    note = "",
                ),
            )
        ),
        Lesson(
            id = 9,
            lessonName = "Kotlin Data Types",
            lessonDescription = "Quick overview of kotlin data-types",
            lessonTopics = listOf(
                LessonTopic(
                    lessonId = 1,
                    topicId = 1,
                    header = "IWhat is Kotlin?",
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
                        "We will learn more about Kotlin in next upcoming lessons. Before that let's see how much we learnt from this lesson (click on this play quiz button).",
                    ),
                    codeExample = "",
                    codeOutPutExample = false,
                    fact = "",
                    note = "",
                ),
            )
        ),
        Lesson(
            id = 10,
            lessonName = "Some More Data Types",
            lessonDescription = "Some more data types in kotlin",
            lessonTopics = listOf(
                LessonTopic(
                    lessonId = 1,
                    topicId = 1,
                    header = "IWhat is Kotlin?",
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
                        "We will learn more about Kotlin in next upcoming lessons. Before that let's see how much we learnt from this lesson (click on this play quiz button).",
                    ),
                    codeExample = "",
                    codeOutPutExample = false,
                    fact = "",
                    note = "",
                ),
            )
        ),
    )
}