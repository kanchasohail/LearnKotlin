package com.social.learnkotlin.model.static_data.lessons_list

import com.social.learnkotlin.model.data_models.Lesson
import com.social.learnkotlin.model.data_models.LessonTopic
import com.social.learnkotlin.model.data_models.QuizModel

val lesson6_KotlinVariables = Lesson(
    id = 6,
    lessonName = "Kotlin Variables",
    lessonDescription = "Kotlin variables and their use",
    pagesCount = 3, lessonTopics = listOf(
        LessonTopic(
            topicId = 1,
            header = "Variable intro - ",
            article = listOf(
                "Variable are used to store data values , in simple words Variable are containers for  storing data values.",
                "Now that you know what a variable is. Let's have a look on how to make a variable and how to use them in different scenarios.",
                "To create a variable, we use var or val, and assign a value to it with the equal sign (=):",
                "For creating a variable we use 'var' or 'val' keyword and then give the variable name after that a '=' sing to assign the value. Pretty confusing right?",
                "Let's understand this with examples.",
            ),
            codeExample = """fun main() {
var variableName = "This is a variable"
val secondVariableName = "This is another variable"

println(variableName)  // It will print the value of variableName
println(secondVariableName) //It will print the value of secondVariableName
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 1,
            header = null,
            article = listOf(
                "In the above example, we can see how we create variables and assign some values to them.",
                "Click on that \"try it yourself\" button and play around it's values and also try to write the whole program from scratch.",
                "It's not compulsory to write the variable names that I have written, you can choose any variable name that you want. But we have some rules and best practices for choosing a variable name that we will see later in this lesson.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = "There are some reserved keywords in Kotlin which we can not use as a name of our variables.",
        ),
        LessonTopic(
            topicId = 2,
            header = "Variable Type -",
            article = listOf(
                "Unlike many other programming languages, variables in Kotlin do not need to be declared with a specified type like \"String\" for text or \"Int\" for numbers.",
                "Let's see an example of how we can create variable for storing text and one for storing number.",
                "However, it is possible to specify the type if you still want, but there is a different way to make variables by specifying its type.",
                "Let's have a look how we can declare variables with its type."
            ),
            codeExample = """fun main() {
var name: String = "Alex" // String
val age: Int = 19 // Int

println(name)
println(birthyear)
}̥""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 2,
            header = null,
            article = listOf(
                "In the above example we used the 'var' or 'val' keyword and the variable name followed by ':' (colon) and then its type after that we put '=' sign and its value. This is how we declare variable by specifying its type.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = "We can declare as many variables as we need in Kotlin or any other programming language.",
            note = null,
        ),

        LessonTopic(
            topicId = 3,
            header = "Declaring variable without values -",
            article = listOf(
                "As far now, we have seen that we have to assign a value to the variable whenever we create them, but what if we want to assign the value later.",
                "Well Kotlin provides us a way to do it. We can also declare a variable without assigning the value, and assign the value later. However, this is only possible when you specify the type.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = "We have to specify the type of the variable if we want to declare it without assigning any value to it.",
        ),
        LessonTopic(
            topicId = 3,
            header = null,
            article = listOf(
                "Let's see an example of declaring variable without assigning any value.",
            ),
            codeExample = """fun main() {
  var name: String
  name = "Alex"
  println(name)
}̥""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 3,
            header = null,
            article = listOf(
                "Well now we have learnt too a lot of things about variable, now it is time to practice them.",
                "Did you notice something? Why do we have two keywords ('var' and 'val') to declare variables and why and how to use them?",
                "We will learn them in the next lesson, Now, it's quiz time!"
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = "We will learn more about variables in the next lesson. Specially the difference between 'var' and 'val' .",
        ),

        ),

    quiz = listOf(
        QuizModel(
            question = "What is variable used for?",
            options = listOf(
                "For printing something",
                "For writing comments",
                "For storing data values"
            ),
            correctAnswer = "For storing data values"
        ),

        QuizModel(
            question = "Which is a correct way of declaring variable?",
            options = listOf(
                "var userName",
                "var String userName",
                "var userName = \"Alex\" "
            ),
            correctAnswer = "var userName = \"Alex\" "
        ),
        QuizModel(
            question = "Can we assign Int(number) value to a variable?",
            options = listOf(
                "No", "Yes"
            ),
            correctAnswer = "Yes"
        ),
        QuizModel(
            question = "How do we declare variable without assigning its value?",
            options = listOf("var name: String", "var name", "val name"),
            correctAnswer = "var name: String"
        ),
    )
)