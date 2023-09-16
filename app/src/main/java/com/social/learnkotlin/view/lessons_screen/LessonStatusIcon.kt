package com.social.learnkotlin.view.lessons_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class LessonStatus {
    Locked, ONGoing, Completed
}

@Composable
fun LessonStatusIcon(
    modifier: Modifier = Modifier,
    radius: Dp = 24.dp,
    status: LessonStatus
) {

    val icon = when(status){
        LessonStatus.Locked -> Icons.Rounded.Lock
        LessonStatus.Completed -> Icons.Rounded.CheckCircle
        LessonStatus.ONGoing -> Icons.Rounded.PlayArrow
    }

    val iconBgColor: Color = when (status) {
        LessonStatus.Locked -> MaterialTheme.colorScheme.secondary.copy(.5f)
        LessonStatus.Completed -> MaterialTheme.colorScheme.primary
        LessonStatus.ONGoing -> MaterialTheme.colorScheme.secondary.copy(.5f)
    }
    Box(
        modifier = modifier
            .size(radius * 2f)
            .background(
                Brush.radialGradient(
                    listOf(
                        iconBgColor,
                        iconBgColor.copy(.5f),
                        Color.Transparent
                    )
                ), shape = CircleShape
            )
            .clip(CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(4.dp)
                .background(iconBgColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "lesson icon",
                modifier = Modifier
                    .fillMaxSize(.85f)
                    .padding(8.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}
