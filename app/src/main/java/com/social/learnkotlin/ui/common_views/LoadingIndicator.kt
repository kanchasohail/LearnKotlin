package com.social.learnkotlin.ui.common_views

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        TwoFloatingArchLoadingIndicator()
    }
}

@Composable
fun TwoFloatingArchLoadingIndicator(
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
    color: Color = Color.Gray,
    strokeWidthP: Dp = 6.dp,
    animationDuration: Int = 1000,
    gapAngle: Float = 40f
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val angle = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = animationDuration
                0f at 0 with LinearOutSlowInEasing // Starting point (0 degrees)
                360f at animationDuration with LinearOutSlowInEasing // Endpoint (360 degrees)
            }
        ), label = ""
    )

    val innerAngle = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -360f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = animationDuration
                0f at 0 with LinearOutSlowInEasing // Starting point (0 degrees)
                -360f at animationDuration with LinearOutSlowInEasing // Endpoint (-360 degrees)
            }
        ), label = ""
    )

    val canvasWidth = with(LocalDensity.current) { size.toPx() }
    val canvasHeight = with(LocalDensity.current) { size.toPx() }
    val archColor = color.copy(alpha = 0.8f)


    val centerX = canvasWidth / 2
    val centerY = canvasHeight / 2
    val strokeWidth = strokeWidthP.value
    val archRadius = (canvasWidth - strokeWidth) / 4
    val startAngle = 45f
    val sweepAngle = 180f
    val archOffset = 10f

    Box(
        modifier = Modifier
            .size(size), contentAlignment = Alignment.Center
    ) {

        Canvas(modifier = modifier.size(size)) {
            rotate(angle.value, Offset(centerX, centerY)) {
                // Draw first arch
                drawArc(
                    color = Color.Red,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle - gapAngle,
                    useCenter = false,
//                topLeft = Offset(centerX - archOffset, centerY - archRadius),
                    size = Size(centerX * 2, centerY * 2),
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )
                // Draw second arch
                drawArc(
                    color = Color.Blue,
                    startAngle = startAngle + sweepAngle,
                    sweepAngle = sweepAngle - gapAngle,
                    useCenter = false,
//                topLeft = Offset(centerX - archOffset, centerY - archRadius),
                    size = Size(centerX * 2, centerY * 2),
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )
            }
        }

        // Inner Arch
        Box(
            modifier = Modifier
                .size(size / 2),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = modifier.size(size)) {
                rotate(innerAngle.value, Offset(centerX / 2, centerY / 2)) {

                    // Draw third arch
                    drawArc(
                        color = Color.Green,
                        startAngle = startAngle + 180,
                        sweepAngle = sweepAngle - gapAngle,
                        useCenter = false,
//                topLeft = Offset(centerX - archOffset, centerY - archRadius),
                        size = Size(centerX, centerY),
                        style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                    )

                    // Draw fourth arch
                    drawArc(
                        color = Color.Magenta,
                        startAngle = startAngle + sweepAngle + 180,
                        sweepAngle = sweepAngle - gapAngle,
                        useCenter = false,
//                topLeft = Offset(centerX - archOffset, centerY - archRadius),
                        size = Size(centerX, centerY),
                        style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                    )
                }
            }
        }
    }
}