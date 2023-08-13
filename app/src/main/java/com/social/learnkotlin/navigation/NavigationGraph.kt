import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.view.editor_screen.EditorScreen
import com.social.learnkotlin.view.lessons_screen.LessonsScreen
import com.social.learnkotlin.view.profile_screen.ProfileScreen
import com.social.learnkotlin.view.reading_screen.ReadingScreen
import com.social.learnkotlin.view.report_problem_screen.IssueDescribingScreen
import com.social.learnkotlin.view.report_problem_screen.IssueSelectingScreen
import com.social.learnkotlin.view.splash_screen.SplashScreen
import com.social.learnkotlin.view.upgrade_to_permium_screen.UpgradeToPremiumScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
//    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
    NavHost(navController = navController, startDestination = Screens.LessonsScreen.route) {

        //Splash Screen
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController)
        }

        //Learning Screen
        composable(Screens.LessonsScreen.route) {
            LessonsScreen(navController = navController)
        }

        //Editor Screen
        composable(Screens.EditorScreen.route) {
            EditorScreen(navController = navController)
        }

        //Profile Screen
        composable(Screens.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }

        //Reading Screen
        composable(Screens.ReadingScreen.route + "/{lesson_index}", arguments = listOf(
            navArgument("lesson_index") {
                type = NavType.StringType
            }
        )) { entry ->
            ReadingScreen(
                navController,
                lessonIndex = entry.arguments?.getString("lesson_index")?.toInt()
            )
        }

        //Upgrade To Premium Screen
        composable(Screens.UpgradeToPremiumScreen.route) {
            UpgradeToPremiumScreen(navController)
        }

        //Report Problem Screens..
        composable(Screens.IssueSelectingScreen.route) {
            IssueSelectingScreen(navController)
        }
        composable(
            Screens.IssueDescribingScreen.route + "/{selected_issue}",
            arguments = listOf(
                navArgument("selected_issue") {
                    type = NavType.StringType
                },
            )
        ) { entry ->
            IssueDescribingScreen(
                navController,
                selectedIssue = entry.arguments?.getString("selected_issue").toString()
            )
        }

    }
}