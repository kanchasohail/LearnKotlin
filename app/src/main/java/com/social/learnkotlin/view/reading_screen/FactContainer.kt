package com.social.learnkotlin.view.reading_screen

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
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.learnkotlin.ui.layout.DefaultFontText

@Composable
fun FactContainer(modifier: Modifier = Modifier , factText:String) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(4.dp))
                .padding(start = 1.dp, top = 1.dp, bottom = 3.dp, end = 3.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(4.dp))
                    .padding(8.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Rounded.Info,
                            contentDescription = "Fact",
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        DefaultFontText(
                            text = "Fact -",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                    DefaultFontText(
                        text = factText,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }