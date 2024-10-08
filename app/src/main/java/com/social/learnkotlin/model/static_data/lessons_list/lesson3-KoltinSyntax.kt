package com.social.learnkotlin.model.static_data.lessons_list

import com.social.learnkotlin.model.data_models.Lesson
import com.social.learnkotlin.model.data_models.LessonTopic
import com.social.learnkotlin.model.data_models.QuizModel

val lesson3_KotlinSyntax = Lesson(
    id = 3,
    lessonName = "Kotlin Syntax",
    lessonDescription = "Quick Introduction to Kotlin syntax",
    pagesCount = 3, lessonTopics = listOf(
        LessonTopic(
            topicId = 1,
            header = "What is Syntax?",
            article = listOf(
                "Syntax refers to the rules that define the structure of a language.",
                "Syntax in computer programming means the rules that control the structure of the symbols, punctuation, and words of a programming language.",
                "Now, let us see a detailed explanation about the Kotlin syntax. This is a basic code example:",
            ),
            codeExample = """fun main() {
  println("Hello World")
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 1,
            header = null,
            article = listOf(
                "The 'fun' keyword is used to declare a function. A function is a block of code designed to perform a particular task. In the example above, it declares the 'main()' function.",
                "The 'main()' function is something you will see in every Kotlin program. This function is used to execute code. Any code inside the curly brackets '{}' of 'main()' function will be executed.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = "Kotlin executes the code in the 'main()' function or being called from the main() function.",
        ),
        LessonTopic(
            topicId = 2,
            header = "What is Main function?",
            article = listOf(
                "The main function in Kotlin is the entry point to a Kotlin program.",
                "For example, the 'println()' function is inside the 'main()' function, meaning that this will be executed. The 'println()' function is used to output/print text, and in our example it will output \"Hello World\".",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = "In Kotlin, code statements do not have to end with a semicolon (';') (which is often required for other programming languages, such as Java, C++, C#, etc.).",
        ),
        LessonTopic(
            topicId = 3,
            header = "Kotlin update -",
            article = listOf(
                "Before Kotlin version 1.3, it was required to use the main() function with parameters, like: fun main(args : Array<String>). The example above had to be written like this to work:",
            ),
            codeExample = """fun main(args : Array<String>) {
  println("Hello World")
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 3,
            header = null,
            article = listOf(
                "But now, this is no longer required, and the program will run fine without it. However, it will not do any harm if you have been using it in the past, and will continue to use it.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = "We don't need to add 'args : Array<String>' these parameters to the main function anymore.",
        ),
    ),
    quiz = listOf(
        QuizModel(
            question = "Which function executes the code in Kotlin?",
            options = listOf("first() function", "main() function", "start() function"),
            correctAnswer = "main() function"
        ),

        QuizModel(
            question = "Which Kotlin function is used to output texts?",
            options = listOf("output()", "write()", "println()"),
            correctAnswer = "println()"
        ),
        QuizModel(
            question = "Do we use ';' (semi-colon) to end the statements in Kotlin?",
            options = listOf("No", "Yes", "Sometimes"),
            correctAnswer = "No"
        ),
        QuizModel(
            question = "Code in main() function executes when they are inside of?",
            options = listOf(
                "'[]' square brackets",
                "'()' round brackets",
                "'{}' curly brackets"
            ),
            correctAnswer = "'{}' curly brackets"
        ),
        QuizModel(
            question = "Which keyword is used to declare a function in Kotlin?",
            options = listOf("function keyword", "fun keyword", "main keyword"),
            correctAnswer = "fun keyword"
        ),
    )
)