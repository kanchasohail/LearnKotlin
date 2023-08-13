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
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import com.social.learnkotlin.ui.common_views.DefaultFontText

@Composable
fun ReadingCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF0E1852))
            .border(2.dp, color = Color(0xFF3747A7), shape = RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {

        DefaultFontText(
            text = "Introduction Lesson",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        repeat(50) {
            DefaultFontText(
                text = "Hello This is a dummy text",
                fontSize = 24.sp,
                color = Color.White
            )
        }

        Divider(
            thickness = 2.dp,
            modifier = Modifier.padding(top = 12.dp),
            color = Color(0xFF3747A7)
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
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
                DefaultFontText(text = "1305")
            }
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bookmark_icon),
                    contentDescription = "Save",
                    tint = Color.White,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )

                Icon(
                    imageVector = Icons.Rounded.Share,
                    contentDescription = "Share",
                    tint = Color.White,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
        }

    }
}