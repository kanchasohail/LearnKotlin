package com.social.learnkotlin.ui.common_views

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.social.learnkotlin.R

@Composable
fun LessonIconWithProgressRing(
    percentage: Float,
    radius: Dp = 24.dp,
    strokeColor: Color = Color.Green,
    iconBgColor: Color = Color.Cyan,
    strokeWidth: Dp = 4.dp,
    animDuration: Int = 800,
    animDelay: Int = 0,
    icon:Int =  R.drawable.ic_more_horizontal,
) {
    var animationPlayed by remember { mutableStateOf(false) }
    val currentPercentage =
        animateFloatAsState(
            targetValue = if (animationPlayed) percentage else 0f, animationSpec = tween(
                durationMillis = animDuration,
                delayMillis = animDelay
            ), label = ""
        )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(modifier = Modifier.size(radius * 2f), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(radius * 2f)) {

            drawArc(
                color = Color.Gray,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(strokeWidth.toPx())
            )

            drawArc(
                color = strokeColor,
                startAngle = -90f,
                sweepAngle = 360 * currentPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        Box(modifier = Modifier
            .background(
                Brush.radialGradient(
                    listOf(
                        iconBgColor,
                        iconBgColor.copy(.5f),
                        Color.Transparent
                    )
                ), shape = CircleShape
            )
            .clip(CircleShape)) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .background(iconBgColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "lesson icon",
                    modifier = Modifier.fillMaxSize().padding(8.dp)
                )
            }
        }
    }
}