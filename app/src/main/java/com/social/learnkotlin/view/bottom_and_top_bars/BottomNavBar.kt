package com.social.learnkotlin.view.bottom_and_top_bars

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.social.learnkotlin.R
import com.social.learnkotlin.navigation.Screens

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.LearningScreen,
        BottomNavItem.CodesScreen,
        BottomNavItem.ProfileScreen
    )

    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    val navBackStackEntry1 by navController.currentBackStackEntryAsState()

    val viewModel = viewModel<BottomNavigationViewModel>()


    when (navBackStackEntry1?.destination?.route) {
        Screens.LessonsScreen.route -> {
            bottomBarState.value = true
        }

        Screens.CodesScreen.route -> {
            bottomBarState.value = true
        }

        Screens.ProfileScreen.route -> {
            bottomBarState.value = true
        }

        else -> {
            bottomBarState.value = false
        }
    }

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
//        exit = slideOutVertically(targetOffsetY = { it }),
        exit = fadeOut(animationSpec = tween(durationMillis = 0, delayMillis = 0)),
        ) {
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.app_bar_background),
            contentColor = Color.White,
            modifier = Modifier.height(60.dp)
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 14.sp
                        )
                    },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.screenRoute,
                    onClick = {
                        viewModel.screenTitle = item.title
                        navController.navigate(item.screenRoute) {

                            navController.graph.startDestinationRoute?.let { screenRoute ->
                                popUpTo(screenRoute) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }

        }
    }
}