package com.social.learnkotlin.model.static_data.lessons_list

import com.social.learnkotlin.model.data_models.Lesson
import com.social.learnkotlin.model.data_models.LessonTopic
import com.social.learnkotlin.model.data_models.QuizModel

val lesson5_KotlinComments = Lesson(
    id = 5,
    lessonName = "Kotlin Comments",
    lessonDescription = "Kotlin comments and their use cases",
    pagesCount = 4,
    lessonTopics = listOf(
        LessonTopic(
            topicId = 1,
            header = "Kotlin Comments",
            article = listOf(
                "Hey, you have passed all the previous lessons! Congratulations for this achievement and I am glad to see you here.",
                "In this lesson, we will learn about Kotlin comments, and why do we need comments and how to use them.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 2,
            header = "What are comments?",
            article = listOf(
                "In programming, comments are portion of the program intended for you and your fellow programmers to understand the code. They are completely ignored by the compiler.",
                "Comments are used to explain the code, and to make it more readable. It can also be used to prevent execution when testing alternative code.",
                "There are two types of comments in Kotlin.",
                "      • Single-line Comments",
                "      • Multi-line Comments",
                "Let's have a detailed look about how these comments work in Kotlin.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 3,
            header = "Single-lined comments -",
            article = listOf(
                "Single-lined comments are also known as End of Line Comments it is called so because, if we use single line comments the code get ignored by the compiler till the end of that line.",
                "We use '//' to write a single-lined comment.",
            ),
            codeExample = """fun main() {
 // This is an example of single-line comment
   println("Hello, World!") // It ignores all the code till the end of that line
// Comments are always ignored by the compiler
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 3,
            header = null,
            article = listOf(
                "In the above example , we can see the the lines written after '//' double forward-slash are being ignored by the compiler. Simply , they are considered as a comment by the compiler.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 4,
            header = "Multi-lined comments -",
            article = listOf(
                "Multi-lined comments are also known as Traditional comments. Multi-lined comments can span over multiple lines.",
                "We use '/*     */' to write multi-lined comments.",
                "Multi-lined Comments  start with '/*' and ends with '*/' . The Kotlin compiler ignores everything from '/*' to '*/'.",
                "Let's see an example of multi-lined comments.",
            ),
            codeExample = """fun main() {
/* This is a multi-line comment.
 * This code prints "Hello, World!".
 */
   println("Hello, World!")
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 4,
            header = null,
            article = listOf(
                "In the above code example , all the code/text gets ignored by the compiler between '/*' and '*/'. It becomes very useful if we want to comment multiple lines.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = "We can also use // (single-lined comment) to comment multiple lines by using // on all the lines.",
            note = null,
        ),

        ),

    quiz = listOf(
        QuizModel(
            question = "Why do we use comments in Kotlin?",
            options = listOf("To make code faster", "To explain code", "To prevent errors"),
            correctAnswer = "To explain code"
        ),

        QuizModel(
            question = "Do compilers ignore comments?",
            options = listOf("Yes", "No"),
            correctAnswer = "Yes"
        ),
        QuizModel(
            question = "How many types of comments are there in Kotlin?",
            options = listOf("One", "Two", "Five"),
            correctAnswer = "Two"
        ),
        QuizModel(
            question = "Which type of comment is this '//' ?",
            options = listOf(
                "Multi-lined comment",
                "Double-lined comment",
                "Single-lined comment"
            ),
            correctAnswer = "Single-lined comment"
        ),
        QuizModel(
            question = "Which one is used to write multi-lined comment in Kotlin?",
            options = listOf("/*   */", "//", "<!--- -->"),
            correctAnswer = "/*   */"
        ),
    )
)