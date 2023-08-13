package com.social.learnkotlin.view.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.learnkotlin.ui.common_views.DefaultFontText

@Preview(showSystemUi = true)
@Composable
fun ProfileStatsSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .background(Color.Black),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            modifier = Modifier.weight(.4f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultFontText(
                text = "Lessons",
                color = Color.White,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )

        }
        Column(
            modifier = Modifier.weight(.4f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultFontText(
                text = "Quiz",
                color = Color.White,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}