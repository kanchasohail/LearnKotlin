package com.social.learnkotlin.model.static_data.lessons_list

import com.social.learnkotlin.model.data_models.Lesson
import com.social.learnkotlin.model.data_models.LessonTopic
import com.social.learnkotlin.model.data_models.QuizModel

val lesson9_KotlinDataTypes = Lesson(
    id = 9,
    lessonName = "Kotlin Data Types",
    lessonDescription = "Quick overview of kotlin data-types",
    pagesCount = 9, lessonTopics = listOf(
        LessonTopic(
            topicId = 1,
            header = "Kotlin Data Types",
            article = listOf(
                "In software programming, data type refers to the type of value a variable has.",
                "And they are the factors that define what kind of mathematical or logical operations can be applied.",
                "In Kotlin, the type of a variable is decided by its value, let's see an example -",
            ),
            codeExample = """val myNum = 5             // Int
val myDoubleNum = 5.99    // Double
val myLetter = 'D'        // Char
val myBoolean = true      // Boolean
val myText = "Hello"      // String""",
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 1,
            header = null,
            article = listOf(
                "However, we learned in the previous lessons that we can specify the type of a variable if we want.",
                "Let's see an example -",
            ),
            codeExample = """val myNum: Int = 5                // Int
val myDoubleNum: Double = 5.99    // Double
val myLetter: Char = 'D'          // Char
val myBoolean: Boolean = true     // Boolean
val myText: String = "Hello"      // String""",
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 1,
            header = null,
            article = listOf(
                "Sometimes we have to specify the type, and often we don't. Anyhow, it is good to know what the different types represent.",
                "We will learn more about when we need to specify the type later.",
                "Data types are divided into different groups:",
                "• Numbers ",
                "• Characters",
                "• Booleans",
                "• Strings",
                "• Arrays",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 2,
            header = "Numbers -",
            article = listOf(
                "In Kotlin there are six types that represent the numbers.",
                "1. Byte",
                "2. Short",
                "3. Int",
                "4. Long",
                "5. Float",
                "6. Double",
                "For the sake of simplicity I have divided them into two main parts:",
                "• Integer types",
                "• Floating point types",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 2,
            header = null,
            article = listOf(
                "Integer types store whole numbers, positive or negative, without decimals and its types are -",
                "• Byte ",
                "• Short",
                "• Int",
                "• Long",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 2,
            header = null,
            article = listOf(
                "Floating point types represent numbers with a fractional part, containing one or more decimals and its types are -",
                "• Float",
                "• Double",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = "If you don't specify the type for a numeric variable, it is most often returned as Int for whole numbers and Double for floating point numbers.",
        ),
        LessonTopic(
            topicId = 3,
            header = "Byte",
            article = listOf(
                "The Byte data type can store whole numbers from -128 to 127.",
                "This can be used instead of Int or other integer data types to save memory when if it's certain that the value will be within -128 and 127.",
                "Let's see an example -",
            ),
            codeExample = """fun main() {
    val test: Byte = 112
    println(test)
}""",
            codeOutPutExample = true,
            fact = null,
            note = "We can not assign value greater than 127 or smaller than -128 to a variable of type Byte.",
        ),
        LessonTopic(
            topicId = 4,
            header = "Short",
            article = listOf(
                "The Short data type can have number values from -32768 to 32767 .",
                "It is used instead of other integer data types to save memory if it's certain that the value of the variable will be within -32768 and 32767.",
                "Let's see an example -",
            ),
            codeExample = """fun main() {
    val temperature: Short = -11245
    println(temperature)
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 5,
            header = "Int",
            article = listOf(
                "The Int data type can store whole numbers from -2147483648 to 2147483647.",
                "It is the most used type for storing numbers.",
                "Let's see an example -",
            ),
            codeExample = """fun main(){
val myNum: Int = 100000
println(myNum)
}""",
            codeOutPutExample = true,
            fact = null,
            note = "If you assign an integer between -2147483648 to 2147483647 to a variable without explicitly specifying its type, the variable will be of Int type.",
        ),
        LessonTopic(
            topicId = 6,
            header = "Long",
            article = listOf(
                "The Long data type can store whole numbers from -9223372036854775807 to 9223372036854775807.",
                "This is used when Int is not large enough to store the value.",
                "If you assign an integer value greater than 9223372036854775807 or less than -9223372036854775807 to a variable without explicitly specifying its type, the variable will be of Long type.",
                "Let's see an example -"
            ),
            codeExample = """fun main(){
val myNum: Long = 15000000000
println(myNum)
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 6,
            header = null,
            article = listOf(
                "Optionally, we can use capital letter 'L' to specify that the variable is of type Long. For example -",
            ),
            codeExample = """fun main(){
     val myNum = 100L 
}""",
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 7,
            header = "Float",
            article = listOf(
                "Floating point types represent numbers with a decimal, such as 9.99 or 3.14515.",
                "Let's see an example -",
            ),
            codeExample = """fun main(){
val myNum: Float = 5.75F
println(myNum)
}""",
            codeOutPutExample = true,
            fact = null,
            note = null,
        ),
        LessonTopic(
            topicId = 7,
            header = null,
            article = listOf(

                "Notice that, we have used 5.75F instead of 5.75 in the above program. It is because 5.75 is a Double literal, and you cannot assign Double value to a variable of type Float."

            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = "We should end the value of a Float type with an \"F\".",
        ),
        LessonTopic(
            topicId = 8,
            header = "Double",
            article = listOf(
                "Double point types represent numbers with a decimal, such as 9.99 or 3.14515.",
                "But this time we do not need to use letter 'F' at the end. For example -"
            ),
            codeExample = """fun main(){
val myNum: Double = 5.75
println(myNum)
}""",
            codeOutPutExample = true,
            fact = null,
            note = "It's recommended to use Double type for number having decimals point because it has precision of about 15 digits whereas Float has only six or seven.",
        ),
        LessonTopic(
            topicId = 9,
            header = "Number",
            article = listOf(
                "If you are not sure what number value a variable will be assigned in the program, you can specify it as 'Number' type.",
                "This allows you to assign both integer and floating-point value to the variable (one at a time).",
                "Let's see an example -",
            ),
            codeExample = """fun main() {

    var test: Number = 12.2
    println(test)

    test = 12
    // Int smart cast from Number
    println(test)

    test = 120L
    // Long smart cast from Number
    println(test)
}""",
            codeOutPutExample = true,
            fact = null,
            note = "Number data type can store integers and also numbers with decimal points.",
        ),
        LessonTopic(
            topicId = 9,
            header = null,
            article = listOf(
                "That's a lot for this lesson, we will learn about more data types in the next lessons.",
                "Let's play the quiz.",
            ),
            codeExample = null,
            codeOutPutExample = false,
            fact = null,
            note = null,
        ),
    ),
    quiz = listOf(
        QuizModel(
            question = "Which keyword do we use to represent a Character data type in Kotlin?",
            options = listOf(
                "Character", "Char", "C"
            ),
            correctAnswer = "Char"
        ),

        QuizModel(
            question = "What is a correct way of declaring a Character variable?",
            options = listOf(
                "val letter: Char = 'A'",
                "val letter: Character = 'A'",
                "var letter: Car = 'A'",
            ),
            correctAnswer = "val letter: Char = 'A'"
        ),
        QuizModel(
            question = "What values can a Boolean store?",
            options = listOf(
                "Text", "Numbers", "True/False"
            ),
            correctAnswer = "True/False"
        ),
        QuizModel(
            question = "Which data type do we use to store a sequence of characters (text)?",
            options = listOf(
                "Char",
                "String",
                "Long",
            ),
            correctAnswer = "String"
        ),
        QuizModel(
            question = "Which data type is used to store multiple values in a single variable?",
            options = listOf("Array", "Double", "Int"),
            correctAnswer = "Array"
        ),
    )
)