package com.social.learnkotlin.view.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.social.learnkotlin.ui.layout.scaffoldGradientBg

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel = viewModel<ProfileScreenViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(scaffoldGradientBg())
    ) {
        //TODO this profile picture section is creating a lot of performance issues
        ProfilePictureSection(viewModel = viewModel, context = context)
        UserNameSection(viewModel = viewModel, context = context)
        ProfileStatsSection(navController = navController)
    }

}
