package com.social.learnkotlin.ui.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.social.learnkotlin.R
import com.social.learnkotlin.ui.theme.gradientEndGreen

@Composable
fun scaffoldGradientBg(): Brush {
    return Brush.linearGradient(
        listOf(
            Color.Black,
           gradientEndGreen
        )
    )
}