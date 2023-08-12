package com.social.learnkotlin.view.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.social.learnkotlin.R
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.ui.common_views.DefaultFontText
import com.social.learnkotlin.ui.common_views.TwoFloatingArchLoadingIndicator
import com.social.learnkotlin.ui.common_views.bottomBorder
import com.social.learnkotlin.ui.common_views.scaffoldGradientBg

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel = viewModel<ProfileScreenViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(scaffoldGradientBg())
    ) {
        ProfilePictureSection(viewModel = viewModel, context = context)
        UserNameSection(viewModel = viewModel, context = context)
        StatsSection()
        ProfilePageOptions(navController = navController)
    }

}


@Composable
private fun StatsSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            TwoFloatingArchLoadingIndicator()
        }
        Column {
            TwoFloatingArchLoadingIndicator()
        }
        Column {
            TwoFloatingArchLoadingIndicator()
        }
    }
}

@Composable
private fun ProfilePageOptions(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(5) {
            OptionItem(optionName = "Report a problem", icon = R.drawable.ic_report, onClick = {
                navController.navigate(
                    Screens.IssueSelectingScreen.route
                )
            })
        }
    }
}

@Composable
private fun OptionItem(
    modifier: Modifier = Modifier,
    optionName: String,
    icon: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .bottomBorder(1.dp, Color.Gray)
            .padding(vertical = 12.dp, horizontal = 8.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            modifier = Modifier
                .size(26.dp),
            contentDescription = optionName,
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(8.dp))
        DefaultFontText(text = optionName, fontSize = 22.sp, color = Color.White)
    }

}
