package com.social.learnkotlin.view.quiz_result_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.learnkotlin.ui.layout.DefaultFontText
import com.social.learnkotlin.ui.theme.greenColor
import com.social.learnkotlin.ui.theme.redColor
import com.social.learnkotlin.view.quiz_screen.QuizViewModel

@Composable
fun ResultContainer(playedQuiz: QuizViewModel.PlayedQuizModel, modifier: Modifier = Modifier) {

    val borderColor: Color = if (playedQuiz.isCorrect) greenColor else redColor

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(borderColor, shape = RoundedCornerShape(2.dp))
            .padding(start = 6.dp, top = 1.dp, bottom = 1.dp, end = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(2.dp))
                .padding(vertical = 16.dp, horizontal = 10.dp)
        ) {
            DefaultFontText(text = playedQuiz.question, fontSize = 22.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth() , verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = if (playedQuiz.isCorrect) Icons.Rounded.Check else Icons.Rounded.Close,
                    contentDescription = "",
                    tint = if (playedQuiz.isCorrect) greenColor else redColor,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                DefaultFontText(text = playedQuiz.selectedAnswer , fontSize = 18.sp)
            }
        }
    }
}