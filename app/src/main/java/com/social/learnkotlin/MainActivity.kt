package com.social.learnkotlin

import android.os.Bundle
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.social.learnkotlin.navigation.NavigationGraph
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.ui.theme.LearnKotlinTheme
import com.social.learnkotlin.view.bottom_and_top_bars.BottomNavBar
import com.social.learnkotlin.view.bottom_and_top_bars.BottomNavigationViewModel
import com.social.learnkotlin.view.bottom_and_top_bars.MyAppBar

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val bottomNavViewModel = viewModel<BottomNavigationViewModel>()

            LearnKotlinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navController = rememberNavController()

                    Scaffold(
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
}