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
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun LockedAndCompletedIcon(
    modifier: Modifier = Modifier,
    radius: Dp = 24.dp,
    isLocked: Boolean = true
) {
    val iconBgColor: Color = if (isLocked) Color.Gray else Color.Green
        Box(
            modifier = Modifier.size(radius * 2f)
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
                    imageVector = if (isLocked) Icons.Rounded.Lock else Icons.Rounded.CheckCircle,
                    contentDescription = "lesson icon",
                    modifier = Modifier
                        .fillMaxSize(.85f)
                        .padding(8.dp)
                )
            }
        }
    }
