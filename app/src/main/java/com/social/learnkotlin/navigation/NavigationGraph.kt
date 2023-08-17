import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
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

        //Lessons Screen
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
        composable(Screens.ReadingScreen.route + "/{lesson_index}",
            enterTransition = {
                slideInVertically(
                    initialOffsetY = { -10 },
                    animationSpec = tween(1000, delayMillis = 40, easing = FastOutSlowInEasing)
                )
            },
            arguments = listOf(
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
        composable(
            Screens.UpgradeToPremiumScreen.route,
            enterTransition = {
                slideInVertically(
                    initialOffsetY = { -10 },
                    animationSpec = tween(1000, delayMillis = 40, easing = FastOutSlowInEasing)
                )
            },
        ) {
            UpgradeToPremiumScreen(navController)
        }

        //Report Problem Screens..
        composable(
            Screens.IssueSelectingScreen.route,
            enterTransition = {
                slideInVertically(
                    initialOffsetY = { -10 },
                    animationSpec = tween(1000, delayMillis = 40, easing = FastOutSlowInEasing)
                ) + fadeIn(animationSpec = tween(1000 , delayMillis = 100))
            },
        ) {
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