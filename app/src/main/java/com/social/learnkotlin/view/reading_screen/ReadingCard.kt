package com.social.learnkotlin.view.reading_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.learnkotlin.ui.layout.DefaultFontText

@Composable
fun ReadingCard(modifier: Modifier = Modifier) {
    val contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            DefaultFontText(
                text = "Introduction Lesson",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            repeat(50) {
                DefaultFontText(
                    text = "Hello This is a dummy text",
                    fontSize = 24.sp,
                    color = contentColor
                )
            }
           
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                thickness = 2.dp,
                modifier = Modifier.padding(horizontal = 60.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
