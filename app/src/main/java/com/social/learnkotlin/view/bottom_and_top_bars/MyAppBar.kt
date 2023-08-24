package com.social.learnkotlin.view.bottom_and_top_bars

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.social.learnkotlin.R
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.ui.common_views.DefaultFontText

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyAppBar(
    titleText: String,
    chipText: String = "Premium",
    chipIcon: Int = R.drawable.ic_crown_img,
    onChipClick: () -> Unit,
    backgroundColor: Color = colorResource(id = R.color.app_bar_background),
    navController: NavController
) {

    val appBarState = rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry1 by navController.currentBackStackEntryAsState()


    when (navBackStackEntry1?.destination?.route) {
        Screens.LessonsScreen.route -> {
            appBarState.value = true
        }

        Screens.CodesScreen.route -> {
            appBarState.value = true
        }

        Screens.ProfileScreen.route -> {
            appBarState.value = true
        }

        else -> {
            appBarState.value = false
        }
    }

    AnimatedVisibility(
        visible = appBarState.value,
        enter = slideInVertically(initialOffsetY = { -it }),
//        exit = slideOutVertically(targetOffsetY = { -it }),
        exit = fadeOut(animationSpec = tween(durationMillis = 0, delayMillis = 0)),
    ) {
        TopAppBar(
            backgroundColor = backgroundColor,
            title = {
                DefaultFontText(
                    text = titleText,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge
                )
            },
            actions = {
                Chip(
                    onClick = onChipClick,
                    colors = ChipDefaults.chipColors(
                        backgroundColor = colorResource(id = R.color.chip_color)
                    ),
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Icon(
                        painterResource(id = chipIcon),
                        contentDescription = null,
                        tint = colorResource(id = R.color.crown_color),
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    DefaultFontText(text = chipText, color = Color.White)
                }
            },
            modifier = Modifier.statusBarsPadding()
        )
    }
}