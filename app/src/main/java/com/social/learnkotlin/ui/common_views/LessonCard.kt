package com.social.learnkotlin.ui.common_views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.learnkotlin.R
import com.social.learnkotlin.view.lessons_screen.LockedAndCompletedIcon


@Composable
fun LessonCard(
    modifier: Modifier = Modifier,
    subjectName: String,
    lessonName: String,
    descriptionText: String,
    readingDuration: Int,
    isCompleted:Boolean = false,
    isOnGoing:Boolean = false
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
                .background(Color.DarkGray)
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
          if(isCompleted){
              LockedAndCompletedIcon(isLocked = false)
          }else if(isOnGoing){
              LessonIconWithProgressRing(percentage = 0.7f)
          }else{
              LockedAndCompletedIcon()
          }
        }

        Column(Modifier.padding(16.dp)) {
            DefaultFontText(text = subjectName, fontSize = 16.sp, color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))

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
            ) {
                Icon(
                    imageVector = Icons.Rounded.PlayArrow,
                    contentDescription = "time",
                    tint = Color.White
                )
                DefaultFontText(text = "$readingDuration mins", color = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}