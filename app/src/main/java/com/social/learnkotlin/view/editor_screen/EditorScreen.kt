package com.social.learnkotlin.view.editor_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.social.learnkotlin.ui.common_views.scaffoldGradientBg

@Composable
fun EditorScreen(navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(scaffoldGradientBg())
        ) {

        }
    }
