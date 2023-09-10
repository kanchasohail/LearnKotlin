package com.social.learnkotlin.view.reading_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.learnkotlin.R
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

            Divider(
                thickness = 2.dp,
                modifier = Modifier.padding(top = 12.dp),
                color = MaterialTheme.colorScheme.primary
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { /*TODO*/ }, modifier = Modifier.height(34.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_comment_icon),
                        contentDescription = "Comments",
                        tint = contentColor
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    DefaultFontText(text = "1305")
                }
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bookmark_icon),
                        contentDescription = "Save",
                        tint = contentColor,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )

                    Icon(
                        imageVector = Icons.Rounded.Share,
                        contentDescription = "Share",
                        tint = contentColor,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }
            }
        }
    }
}