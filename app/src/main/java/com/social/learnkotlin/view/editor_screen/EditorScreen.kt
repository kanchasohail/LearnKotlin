package com.social.learnkotlin.view.editor_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.social.learnkotlin.R
import com.social.learnkotlin.ui.common_views.scaffoldGradientBg

@Preview(showSystemUi = true)
@Composable
//fun EditorScreen(navController: NavController) {
fun EditorScreen(navController: NavController = rememberNavController()) {
    var isCodeScreen by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(scaffoldGradientBg())
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(colorResource(id = R.color.app_bar_background)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )

            }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Box(
                        modifier = Modifier
                            .height(38.dp)
                            .width(100.dp)
                            .clip(RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp))
                            .background(
                                if (isCodeScreen) Color.Cyan else Color.Transparent
                            )
                            .border(
                                1.dp,
                                Color.Cyan,
                                shape = RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp)
                            )
                            .clickable {
                                isCodeScreen = true
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Code")
                    }

                    Box(
                        modifier = Modifier
                            .height(38.dp)
                            .width(100.dp)
                            .clip(RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp))
                            .background(
                                if (!isCodeScreen) Color.Cyan else Color.Transparent
                            )
                            .border(
                                1.dp,
                                Color.Cyan,
                                shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp)
                            )
                            .clickable {
                                isCodeScreen = false
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Output")
                    }
                }



                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_save_icon),
                        contentDescription = "Save",
                        tint = Color.White
                    )
                }

            }
        }

    }
