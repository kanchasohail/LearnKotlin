package com.social.learnkotlin.model.static_data.lessons_list

import com.social.learnkotlin.model.data_models.Lesson
import com.social.learnkotlin.model.data_models.LessonTopic
import com.social.learnkotlin.model.data_models.QuizModel

val lesson4_KotlinOutput = Lesson(
    id = 4,
    lessonName = "Kotlin Output",
    lessonDescription = "All about kotlin output",
    pagesCount = 2, lessonTopics = listOf(
        LessonTopic(
            topicId = 1,
            header = "Kotlin Output",
            article = listOf(
                "Kotlin Output  means displaying any output on the screen.",
                "In this lesson, we will learn how to display output to the screen in Kotlin.",
                "The functions 'println()' and 'print()' are used to are used to show output/print text on the screen.",
                "Let's take a look on how these functions work with simple examples.",
                "This code example uses 'println()' function -",
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
                "This code example uses 'print()' function -",
            ),
            codeExample = """fun main() {
  print("Hello World")
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 1,
            header = null,
            article = listOf(
                "Here, 'print()' and 'println()' both outputs the text under the quotes.",
                "So, how are they different and why do we need different functions if both are doing the same thing?",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 2,
            header = "Difference between print() and println() -",
            article = listOf(
                "There is not too much difference between the both , the only difference is -",
                "• print() - simply prints values/string inside the quotes.",
                "• println() - prints values/string inside the quotes similar like print() function and then it adds a new line at the end of the output.",
                "Let's take a closer look on their differences:",
                "print() function - ",
            ),
            codeExample = """fun main() {
  print("Hello World 1 ")
  print("Hello World 2 ")
  print("Hello World 3 ")
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 2,
            header = null,
            article = listOf(
                "In the above example we can clearly see that the output text is printed in one single line instead of adding new line for each 'print()' function.",
                "Now, let's see an example of println() function:",
                "println() function -",
            ),
            codeExample = """fun main() {
  println("Hello World 1 ")
  println("Hello World 2 ")
  println("Hello World 3 ")
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 2,
            header = null,
            article = listOf(
                "In this example output, the 'println()' function adds a new line for each 'println()' function.",
                "I hope the difference between print() and println() functions is clear. Now, I have a task for you.",
                "Try to create this pattern by just using print() and println() functions and share the output on Social media and tag @mdsohail.00 . I will be glad to see that you guy's are doing well.",
                "Here is the pattern - ",
                "photo4",
                "Keep practicing! See you in the next lessons.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = "We can add as many print() and println() functions as we want. Note that it will add a new line for each function.",
        ),
    ),
    quiz = listOf(
        QuizModel(
            question = "What does output mean is Kotlin?",
            options = listOf("Play music", "Display Images", "Print something on screen"),
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