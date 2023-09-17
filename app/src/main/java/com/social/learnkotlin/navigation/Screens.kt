package com.social.learnkotlin.navigation

sealed class Screens(val route: String) {
    object SplashScreen : Screens("splash_screen")
    object LessonsScreen : Screens("lessons_screen")
    object CodesScreen : Screens("codes_screen")
    object EditorScreen : Screens("editor_screen")
    object ProfileScreen : Screens("profile_screen")
    object ReadingScreen : Screens("reading_screen")

    object QuizScreen:Screens("quiz_screen")

    object QuizResultScreen:Screens("quiz_result_screen")
    object UpgradeToPremiumScreen : Screens("upgrade_to_premium_screen")

    //Report problem screens..
    object IssueSelectingScreen:Screens("issue_selecting_screen")
    object IssueDescribingScreen:Screens("issue_describing_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}