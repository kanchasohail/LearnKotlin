package com.social.learnkotlin.view.reading_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.learnkotlin.ui.layout.DefaultFontText

@Composable
fun CodeExampleContainer(
    modifier: Modifier = Modifier,
    codeString: String,
    onTryClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        DefaultFontText(text = "Code Example -", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(4.dp))
                .padding(8.dp)
        ) {
            Text(text = codeString, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(5.dp))

        OutlinedButton(onClick = onTryClick, modifier = Modifier.fillMaxWidth()) {
            DefaultFontText(
                text = "Try it yourself",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}