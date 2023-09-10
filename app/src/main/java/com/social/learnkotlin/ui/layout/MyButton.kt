package com.social.learnkotlin.ui.layout

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.social.learnkotlin.R
import com.social.learnkotlin.ui.layout.DefaultFontText
import com.social.learnkotlin.ui.theme.cyanColor

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    buttonColor: Color = cyanColor,
    buttonTextColor:Color = Color.Black,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = buttonColor
    ) {
        Button(
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            DefaultFontText(
                text = buttonText,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
    }
}