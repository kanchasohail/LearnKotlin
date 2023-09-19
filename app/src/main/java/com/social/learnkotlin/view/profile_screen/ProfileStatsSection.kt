package com.social.learnkotlin.view.profile_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.learnkotlin.ui.layout.DefaultFontText

@Composable
fun ProfileStatsSection(modifier: Modifier = Modifier) {
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
                text = "Your Progress:",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            LinearProgressIndicator(
                progress = .3f,
                trackColor = MaterialTheme.colorScheme.secondary.copy(.5f),
                color = MaterialTheme.colorScheme.primary.copy(.65f),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(35.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            DefaultFontText(
                text = "Finish all the lessons to get your certificate!",
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.padding(5.dp)
            )

        }
    }
}

