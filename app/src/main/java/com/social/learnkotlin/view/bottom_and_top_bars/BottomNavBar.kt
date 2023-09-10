package com.social.learnkotlin.view.bottom_and_top_bars

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
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

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


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
        exit = fadeOut(animationSpec = tween(durationMillis = 0, delayMillis = 0)),
    ) {
        NavigationBar(
            modifier = Modifier.height(76.dp),
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title,
                        )
                    },
                    label = {
                        Text(item.title)
                    },
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