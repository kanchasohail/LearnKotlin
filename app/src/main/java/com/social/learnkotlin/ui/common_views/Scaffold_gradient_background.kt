package com.social.learnkotlin.ui.common_views

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.social.learnkotlin.R

@Composable
fun scaffoldGradientBg(): Brush {
    return Brush.linearGradient(
        listOf(
            Color.Black,
            colorResource(id = R.color.gradient_end_bg)
        )
    )
}