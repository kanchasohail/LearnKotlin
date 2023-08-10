package com.social.learnkotlin.view.splash_screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.social.learnkotlin.R
import com.social.learnkotlin.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val scale = remember {
        Animatable(3f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            1f,
            animationSpec = tween(durationMillis = 500,
                easing = { OvershootInterpolator(2f).getInterpolation(it) })
        )
        delay(3000L)
        navController.popBackStack()
        navController.navigate(Screens.LessonsScreen.route)
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green), contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(id = R.drawable.ic_profile),
            contentDescription = null,
            modifier = Modifier.size(80.dp).scale(scale.value)
        )
    }

}