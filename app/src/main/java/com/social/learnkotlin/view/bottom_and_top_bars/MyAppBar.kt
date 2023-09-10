package com.social.learnkotlin.view.bottom_and_top_bars

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.social.learnkotlin.R
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.ui.layout.DefaultFontText
import com.social.learnkotlin.ui.theme.crownColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    titleText: String,
    chipText: String = "Premium",
    chipIcon: Int = R.drawable.ic_crown_img,
    onChipClick: () -> Unit,
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
            title = {
                DefaultFontText(
                    text = titleText,
                    style = MaterialTheme.typography.titleLarge
                )
            },
            actions = {
                AssistChip(
                    onClick = onChipClick, label = { Text(text = chipText) }, leadingIcon = {
                        Icon(
                            painterResource(id = chipIcon),
                            contentDescription = null,
                            tint = crownColor,
                            modifier = Modifier
                                .size(20.dp)
                                .padding(bottom = 2.dp)
                        )
                    }, modifier = Modifier.padding(end = 8.dp))
            },
            modifier = Modifier.statusBarsPadding().shadow(elevation = 6.dp),
        )
    }
}