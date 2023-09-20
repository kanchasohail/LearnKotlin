package com.social.learnkotlin.view.profile_screen

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.learnkotlin.model.static_data.AllLessons
import com.social.learnkotlin.ui.layout.DefaultFontText
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun ProfileStatsSection(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val onGoingLessonIndexKey = "on_going_lesson_index"
    val prefs by lazy {
        context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }

    val onGoingLessonIndex = prefs.getInt(onGoingLessonIndexKey, 0)

    val percentageValue  = onGoingLessonIndex.toDouble() / AllLessons.lessonsList.size * 100


    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.DOWN
    val percentageString = df.format(percentageValue)

    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(.5f)
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            DefaultFontText(
                text = "Learning Progress:",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .clip(RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center
            ) {
                LinearProgressIndicator(
                    progress = (percentageValue / 100).toFloat(),
                    trackColor = MaterialTheme.colorScheme.primary.copy(.3f),
                    color = MaterialTheme.colorScheme.primary.copy(.7f),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                )

                DefaultFontText(
                    text = "$percentageString%",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            DefaultFontText(
                text = "Finish all the lessons to get your certificate!",
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.padding(5.dp)
            )

        }
    }
}

