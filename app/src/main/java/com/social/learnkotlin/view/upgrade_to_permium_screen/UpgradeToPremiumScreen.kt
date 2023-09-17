package com.social.learnkotlin.view.upgrade_to_permium_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.social.learnkotlin.R
import com.social.learnkotlin.ui.common_views.bottomBorder
import com.social.learnkotlin.ui.layout.DefaultFontText
import com.social.learnkotlin.ui.layout.MyButton
import com.social.learnkotlin.ui.theme.RubikFontFamily
import com.social.learnkotlin.ui.theme.crownColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpgradeToPremiumScreen(navController: NavController) {
    val viewModel = viewModel<UpgradeToPremiumViewModel>()
    val contentColor = MaterialTheme.colorScheme.onBackground
    val primaryColor = MaterialTheme.colorScheme.primary

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_crown_img),
                        contentDescription = "pro",
                        tint = crownColor,
                        modifier = Modifier
                            .size(38.dp)
                            .padding(bottom = 3.dp, start = 5.dp)
                    )
                },
                title = {
                    DefaultFontText(text = "Premium", fontSize = 30.sp, color = contentColor)
                },
                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = "close",
                            tint = contentColor,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                modifier = Modifier.shadow(6.dp)
            )
        },

        bottomBar = {
            BottomAppBar(Modifier.size(0.dp)) {
            }
        },

        ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.padding(top = 10.dp))

            Text(
                text = buildAnnotatedString {
                    append("Get Premium for just")

                    withStyle(style = SpanStyle(color = primaryColor)) {
                        append("\n2.99$")
                    }
                },
                style = TextStyle(
                    fontSize = 35.sp,
                    lineHeight = 40.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = contentColor,
                    fontFamily = RubikFontFamily
                ),
                modifier = Modifier.fillMaxWidth()

            )

            FeaturesListCard()
            Spacer(modifier = Modifier.weight(1f))
            MyButton(
                buttonText = "Get Premium",
                buttonTextColor = MaterialTheme.colorScheme.onPrimary,
                buttonColor = primaryColor,
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
            ) {

            }
        }

    }
}

@Composable
fun FeaturesListCard(
    modifier: Modifier = Modifier,
) {
    val internalBgColor = MaterialTheme.colorScheme.secondary.copy(0.25f)
    val externalBgColor = MaterialTheme.colorScheme.primary.copy(0.2f)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .background(
                            internalBgColor
                        ), contentAlignment = Alignment.Center
                ) {
                    TopModeText(title = "Basic")
                }
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .background(
                            externalBgColor
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    TopModeText(title = "Pro")
                }
            }

            BenefitListItem(
                title = "Read any lesson",
                isLocked = false,
                internalBgColor = internalBgColor,
                externalBgColor = externalBgColor
            )
            BenefitListItem(
                title = "Coding playground practice",
                isLocked = false,
                internalBgColor = internalBgColor,
                externalBgColor = externalBgColor
            )
            BenefitListItem(
                title = "Certificate",
                isLocked = false,
                internalBgColor = internalBgColor,
                externalBgColor = externalBgColor
            )
            BenefitListItem(
                title = "Premium Certificate",
                internalBgColor = internalBgColor,
                externalBgColor = externalBgColor
            )
            BenefitListItem(
                title = "No Advertisements",
                internalBgColor = internalBgColor,
                externalBgColor = externalBgColor
            )
            BenefitListItem(
                title = "Take Quizzes Offline",
                isLastItem = true,
                internalBgColor = internalBgColor,
                externalBgColor = externalBgColor
            )

        }
    }

}

@Composable
private fun TopModeText(
    title: String,
    modifier: Modifier = Modifier
) {
    DefaultFontText(
        text = title,
        fontSize = 18.sp,
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
            .padding(vertical = 10.dp)
    )
}

@Composable
private fun BenefitListItem(
    modifier: Modifier = Modifier,
    title: String,
    isLocked: Boolean = true,
    isLastItem: Boolean = false,
    dividerWidth: Dp = 1.dp,
    internalBgColor: Color,
    externalBgColor: Color
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .bottomBorder(dividerWidth, if (isLastItem) Color.Transparent else Color.Gray)
            .padding(bottom = dividerWidth),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.weight(0.8f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DefaultFontText(
                text = title,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.fillMaxWidth(0.7f)
            )
            if (isLocked) IconBox(
                icon = Icons.Rounded.Lock,
                iconColor = Color.Gray,
                backGroundColor = internalBgColor,
            ) else IconBox(backGroundColor = internalBgColor)
        }
        IconBox(backGroundColor = externalBgColor)
    }
}

@Composable
private fun IconBox(
    modifier: Modifier = Modifier,
    boxSize: Dp = 80.dp,
    icon: ImageVector = Icons.Rounded.CheckCircle,
    iconColor: Color = MaterialTheme.colorScheme.primary,
    backGroundColor: Color
) {
    Box(
        modifier = modifier
            .size(boxSize)
            .background(backGroundColor),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Icon",
            tint = iconColor,
        )
    }
}