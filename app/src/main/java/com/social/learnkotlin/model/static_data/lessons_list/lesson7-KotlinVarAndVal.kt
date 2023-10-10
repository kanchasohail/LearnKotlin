package com.social.learnkotlin.model.static_data.lessons_list

import com.social.learnkotlin.model.data_models.Lesson
import com.social.learnkotlin.model.data_models.LessonTopic
import com.social.learnkotlin.model.data_models.QuizModel

val lesson7_KotlinVarAndVal = Lesson(
    id = 7,
    lessonName = "Kotlin var and val",
    lessonDescription = "Difference between var and val and their use cases",
    pagesCount = 2, lessonTopics = listOf(
        LessonTopic(

            topicId = 1,
            header = "Kotlin var and val",
            article = listOf(
                "In the previous lesson we learnt about variables and their use.",
                "But we saw that there were two way to define a variable in Kotlin 'val' and 'var'.",
                "So In this lesson, we will see what is the difference between 'val' and 'var' and what is their different use cases.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 2,
            header = "Difference -",
            article = listOf(
                "When we create a variable with the 'val' keyword, its value cannot be changed or reassigned.",
                "The following example will generate an error:",
            ),
            codeExample = """ /* Wrong code Example */

fun main() {
	val name = "Alex"
	name = "John"  
	println(name)
}̥""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 2,
            header = null,
            article = listOf(
                "In the above example the code example generates an error because we already know when variable is created with 'val' keyword its value cannot be changed or reassigned.",
                "But what if we have a use case when it is required to change the value of a variable?",
                "Now comes the use of 'var'. Let's see an example.",
            ),
            codeExample = """fun main() {
	var name = "Alex"
	name = "John"  
	println(name)
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 2,
            header = null,
            article = listOf(
                "The above example code will be executed successfully without any error. It is because we can change/reassign the value of a variable created with 'var' keyword.",
                "Now, I hope the difference between 'var' and 'val' is clear. Let's play the quiz.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = "The val keyword is useful when you want a variable to always store the same value.",
            note = null,
        ),
    ),
    quiz = listOf(
        QuizModel(
            question = "Can we reassign a variable created with 'val'?",
            options = listOf(
                "Yes", "No"
            ),
            correctAnswer = "No"
        ),

        QuizModel(
            question = "When do we use var or val keyword?",
            options = listOf(
                "To create a variable",
                "To create functions",
                "To print something"
            ),
            correctAnswer = "To create a variable"
        ),
        QuizModel(
            question = "Whose value can be reassigned?",
            options = listOf(
                "variable with 'val' keyword",
                "variable with 'var' keyword",
                "Both"
            ),
            correctAnswer = "variable with 'var' keyword"
        ),
    )
)