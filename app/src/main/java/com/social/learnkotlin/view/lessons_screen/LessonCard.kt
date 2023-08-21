package com.social.learnkotlin.view.lessons_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.learnkotlin.R
import com.social.learnkotlin.ui.common_views.DefaultFontText
import com.social.learnkotlin.ui.common_views.LessonIconWithProgressRing


@Composable
fun LessonCard(
    modifier: Modifier = Modifier,
    lessonName: String,
    descriptionText: String,
    pagesCount: Int,
    isCompleted: Boolean = false,
    isOnGoing: Boolean = false
) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(colorResource(id = R.color.app_bar_background))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .then(Modifier.graphicsLayer(alpha = 0.5f))
                    .background(
                        Brush.linearGradient(
                            listOf(
                                Color.Black,
                                Color.Green
                            )
                        )
                    )
                    .paint(
                        painter = painterResource(id = R.drawable.kotlin_bg),
                        contentScale = ContentScale.FillBounds
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), contentAlignment = Alignment.CenterStart
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (isCompleted) {
                        LockedAndCompletedIcon(isLocked = false)
                    } else if (isOnGoing) {
                        LessonIconWithProgressRing(percentage = 0.7f)
                    } else {
                        LockedAndCompletedIcon()
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    DefaultFontText(
                        text = lessonName,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

            }
        }

        Column(Modifier.padding(16.dp)) {
            DefaultFontText(
                text = lessonName,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))

            DefaultFontText(text = descriptionText, color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        colorResource(id = R.color.chip_color)
                    )
                    .padding(horizontal = 7.dp, vertical = 2.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_pages_icon),
                    contentDescription = "time",
                    tint = Color.White,
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(3.dp))
                DefaultFontText(text = "$pagesCount pages", color = Color.White)
            }
        }
    }
}