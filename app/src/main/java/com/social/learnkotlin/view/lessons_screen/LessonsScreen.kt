package com.social.learnkotlin.view.lessons_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.ui.common_views.DefaultFontText
import com.social.learnkotlin.ui.common_views.LessonCard
import com.social.learnkotlin.ui.common_views.LessonIconWithProgressRing
import com.social.learnkotlin.ui.common_views.scaffoldGradientBg

@Composable
fun LearningScreen(navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    scaffoldGradientBg()
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { navController.navigate(Screens.ReadingScreen.route) }) {
                DefaultFontText(text = "Reading Screen")
            }
            Spacer(modifier = Modifier.height(10.dp))
            LessonIconWithProgressRing(0.7f)

            Spacer(modifier = Modifier.height(10.dp))
            LessonCard(
                subjectName = "Html Intro",
                lessonName = "Introduction",
                descriptionText = "Your intro to html starts here!",
                readingDuration = 2
            )

        }
}