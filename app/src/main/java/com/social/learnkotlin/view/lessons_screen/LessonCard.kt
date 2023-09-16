package com.social.learnkotlin.view.lessons_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.learnkotlin.ui.layout.DefaultFontText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonCard(
    modifier: Modifier = Modifier,
    lessonName: String,
    descriptionText: String,
    pagesCount: Int,
    isCompleted: Boolean = false,
    isOnGoing: Boolean = false,
    onClick: () -> Unit
) {

    val contentColor = MaterialTheme.colorScheme.onSecondaryContainer
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(CardDefaults.shape)
            .clickable {
                onClick()
            },
        elevation = CardDefaults.elevatedCardElevation(
            4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if(isOnGoing)MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DefaultFontText(
                    text = lessonName,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = contentColor
                )

                if (isCompleted) {
                    LessonStatusIcon(status = LessonStatus.Completed)
                } else if (isOnGoing) {
                    LessonStatusIcon(status = LessonStatus.ONGoing)
                } else {
                    LessonStatusIcon(status = LessonStatus.Locked)
                }
            }


            Column(Modifier.padding(start = 12.dp, bottom = 12.dp)) {
                DefaultFontText(
                    text = descriptionText,
                    color = contentColor,
                    modifier = Modifier.fillMaxWidth(.82f)
                )
                Spacer(modifier = Modifier.height(10.dp))

                AssistChip(
                    onClick = { /*TODO*/ },
                    label = { DefaultFontText(text = "$pagesCount pages") })

            }
        }
    }
}