package com.social.learnkotlin

import NavigationGraph
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.ui.theme.LearnKotlinTheme
import com.social.learnkotlin.view.bottom_and_top_bars.BottomNavBar
import com.social.learnkotlin.view.bottom_and_top_bars.BottomNavigationViewModel
import com.social.learnkotlin.view.bottom_and_top_bars.MyAppBar

class MainActivity : ComponentActivity() {

    private var pressedTime: Long = 0

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val bottomNavViewModel = viewModel<BottomNavigationViewModel>()

            LearnKotlinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()
//                    NavigationGraph(navController = navController)
                    Scaffold(
                        containerColor = colorResource(id = R.color.gradient_end_bg),
                        topBar = {
                            MyAppBar(
                                titleText = bottomNavViewModel.screenTitle,
                                chipText = "Premium",
                                chipIcon = R.drawable.ic_crown_img,
                                onChipClick = {
                                    navController.navigate(Screens.UpgradeToPremiumScreen.route)
                                },
                                navController = navController
                            )
                        },
                        bottomBar = {
                            Box(Modifier.navigationBarsPadding()) {
                                BottomNavBar(navController)
                            }
                        }
                    ) { paddingValues ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues)
                        ) {
                            NavigationGraph(navController = navController)
                        }

                    }
                }
            }
        }
    }

    // on below line we are calling on back press method.
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        // on below line we are checking if the press time is greater than 2 sec
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            // if time is greater than 2 sec we are closing the application.
            super.onBackPressed()
            finish()
        } else {
            // in else condition displaying a toast message.
            Toast.makeText(baseContext, "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        // on below line initializing our press time variable
        pressedTime = System.currentTimeMillis();
    }


}