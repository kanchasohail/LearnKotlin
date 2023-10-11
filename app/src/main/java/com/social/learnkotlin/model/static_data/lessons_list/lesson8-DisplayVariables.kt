package com.social.learnkotlin.model.static_data.lessons_list

import com.social.learnkotlin.model.data_models.Lesson
import com.social.learnkotlin.model.data_models.LessonTopic
import com.social.learnkotlin.model.data_models.QuizModel

val lesson8_DisplayVariables = Lesson(
    id = 8,
    lessonName = "Display Variables",
    lessonDescription = "Let's learn how to display variables",
    pagesCount = 2, lessonTopics = listOf(
        LessonTopic(
            topicId = 1,
            header = "Display Variables",
            article = listOf(
                "We have learnt a lot about variables and we were often using 'println()' method to display the variables.",
                "We created a variable and put it inside the 'println()' function to display it. But wait , there is more...",
                "We can also combine both text and a variable, use the '+' character. Let's see an example.",
            ),
            codeExample = """fun main() {
	val name = "Alex"
	println("Hello " + name)
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 1,
            header = null,
            article = listOf(
                "As , we can see in the above code example it printed the text inside the variable but also added the text that was already there in the print function.",
                "So, the final output was - \"Hello Alex\". ",
                "In this example we added text with a variable but what if we want to add two variables?",
                "Let's see an example - ",
            ),
            codeExample = """fun main() {
	val firstName = "Mr "
	val lastName = "Alex"
	val fullName = firstName + lastName
	println(fullName)
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 1,
            header = null,
            article = listOf(
                "In the above example we created two variables named firstName and lastName , after that we combined both variables using + (plus-operator) and stored the value in a variable called fullName.",
                "In this case both were variables contain strings (text) , but it also work for integers (numbers).",
                "Let's see an example - ",
            ),
            codeExample = """fun main() {
	val x = 5
	val y = 7
	println(x + y)
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 1,
            header = null,
            article = listOf(
                "From the example above, you can expect:",
                "x stores the value 5",
                "y stores the value 7",
                "Then we use the println() method to display the value of x + y, which is 12",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = "For numeric values, the + character works as a mathematical operator.",
        ),
        LessonTopic(
            topicId = 2,
            header = "Variable Names -",
            article = listOf(
                "A variable can have a short name (like x and y) or more descriptive names (age, sum, totalVolume).",
                "The general rule for Kotlin variables are:",
                "• Names can contain letters, digits, underscores, and dollar signs",
                "• Names should start with a letter",
                "• Names can also begin with \$ and _ (but we will not use it in this tutorial)",
                "• Names are case sensitive (\"myVar\" and \"myvar\" are different variables)",
                "• Names should start with a lowercase letter and it cannot contain whitespace",
                "• Reserved words (like Kotlin keywords, such as var or String) cannot be used as names",
                "You might notice that we used firstName and lastName as variable names in the example above, instead of firstname and lastname. This is called \"camelCase\", and it is considered as good practice as it makes it easier to read when you have a variable name with different words in it, for example \"myFavoriteFood\", \"rateActionMovies\" etc."
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = "It is considered as a good practice if we use camelCase for naming our variables.",
            note = null,
        ),
    ),

    quiz = listOf(
        QuizModel(
            question = "Which operator is used to add two variables?",
            options = listOf(
                "++", "+", "×"
            ),
            correctAnswer = "+"
        ),

        QuizModel(
            question = "Can we use reserved words as a variable name?",
            options = listOf(
                "Yes",
                "No",
            ),
            correctAnswer = "No"
        ),
        QuizModel(
            question = "Which of these is written in camel case?",
            options = listOf(
                "username", "UserName", "userName"
            ),
            correctAnswer = "userName"
        ),
    )
)