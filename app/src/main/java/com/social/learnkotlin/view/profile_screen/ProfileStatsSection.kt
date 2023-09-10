package com.social.learnkotlin.view.profile_screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.social.learnkotlin.R
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.ui.layout.DefaultFontText

@Composable
fun ProfileStatsSection(modifier: Modifier = Modifier, navController: NavController) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            8.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            DefaultFontText(
                text = "Your Progress:",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            LinearProgressIndicator(
                progress = .3f,
                trackColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(35.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            DefaultFontText(
                text = "Complete this to get your certificate!",
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.padding(5.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            DefaultFontText(
                text = "About Us",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            ProfilePageOptions(navController = navController)

        }
    }
}


@Composable
private fun ProfilePageOptions(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val textColor = MaterialTheme.colorScheme.onSecondaryContainer
    val context = LocalContext.current

    Column(modifier = modifier.fillMaxWidth()) {
        CardButton(
            textColor = textColor,
            buttonTitle = "Report a Problem",
            icon = R.drawable.ic_report
        ) {
            navController.navigate(
                Screens.IssueSelectingScreen.route
            )
        }
        CardButton(
            textColor = textColor,
            icon = R.drawable.ic_twitter_icon,
            buttonTitle = "Follow us",
        ) {
            val urlIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.twitter.com")
            )
            context.startActivity(urlIntent)
        }

        CardButton(
            textColor = textColor,
            buttonTitle = "Visit Website",
            icon = R.drawable.ic_website_icon,
        ) {
            val urlIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com")
            )
            context.startActivity(urlIntent)
        }
    }

}


@Composable
private fun CardButton(
    modifier: Modifier = Modifier,
    textColor: Color,
    buttonTitle: String,
    icon: Int,
    iconSize: Dp = 28.dp,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clip(CardDefaults.shape)
            .border(
                1.dp,
                MaterialTheme.colorScheme.primary,
                shape = CardDefaults.shape
            )
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        elevation = CardDefaults.cardElevation(
            8.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DefaultFontText(text = buttonTitle, color = textColor, fontSize = 17.sp)
            Icon(
                painter = painterResource(id = icon),
                contentDescription = buttonTitle,
                tint = textColor,
                modifier = Modifier.size(iconSize),
            )
        }
    }
}

