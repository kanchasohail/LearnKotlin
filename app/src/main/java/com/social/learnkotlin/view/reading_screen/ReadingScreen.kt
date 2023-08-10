package com.social.learnkotlin.view.reading_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.social.learnkotlin.R
import com.social.learnkotlin.ui.common_views.DefaultFontText
import com.social.learnkotlin.ui.common_views.MyButton
import com.social.learnkotlin.ui.common_views.scaffoldGradientBg

@Composable
fun ReadingScreen(navController: NavController) {
    val context = LocalContext.current

    val viewModel = viewModel<ReadingScreenViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ReadingScreenViewModel(context = context) as T
            }
        }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                title = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    ) {
                        DefaultFontText(text = "Introduction", color = Color.White , fontSize = 20.sp , fontWeight = FontWeight.SemiBold)
                        LessonsCountBar(
                            dashCount = viewModel.totalLessons,
                            completedLessons = viewModel.completedLessons
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                backgroundColor = colorResource(
                    id = R.color.app_bar_background
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.Transparent,
                modifier = Modifier
                    .height(70.dp)
                    .background(scaffoldGradientBg())
            ) {
                BottomButtons {
                    viewModel.onNextClick()
                }
            }
        }
    ) { paddingValues ->
        val scrollState = rememberScrollState(
            initial = viewModel.initialScrollPosition
        )

        LaunchedEffect(scrollState) {
            viewModel.saveScrollPosition(scrollState)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    scaffoldGradientBg()
                )
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ReadingCard(modifier = Modifier.padding(10.dp))
        }

    }
}

@Composable
private fun LessonsCountBar(dashCount: Int, completedLessons: Int, strokeWidth: Float = 8f) {
    Row(modifier = Modifier.fillMaxWidth(0.8f)) {

        val totalLength = (dashCount * 2 - 1).toFloat()

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val startY = size.height / 2f
            val endX = size.width
            var currentX = 0f
            var currentBarNo = 1

            while (currentX < endX) {
                drawLine(
                    color = if (currentBarNo <= completedLessons) Color.Cyan else Color.Black,
                    start = Offset(currentX, startY),
                    end = Offset(currentX + (size.width / totalLength), startY),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
                currentX += (size.width / totalLength) * 2
                currentBarNo++
            }
        }
    }
}


@Composable
private fun ReadingCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF0E1852))
            .border(2.dp, color = Color(0xFF3747A7), shape = RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {

        DefaultFontText(
            text = "Introduction Lesson",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        repeat(50) {
            DefaultFontText(
                text = "Hello This is a dummy text",
                fontSize = 24.sp,
                color = Color.White
            )
        }

        Divider(
            thickness = 2.dp,
            modifier = Modifier.padding(top = 12.dp),
            color = Color(0xFF3747A7)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.height(34.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_comment_icon),
                    contentDescription = "Comments",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
                DefaultFontText(text = "1305")
            }
            Row() {
                Icon(
                    painter = painterResource(id = R.drawable.ic_save_icon),
                    contentDescription = "Save",
                    tint = Color.White,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )

                Icon(
                    imageVector = Icons.Rounded.Share,
                    contentDescription = "Share",
                    tint = Color.White,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
        }

    }
}


@Composable
private fun BottomButtons(onNextClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp)
    ) {

        MyButton(
            buttonText = "Ask a question",
            modifier = Modifier.fillMaxWidth(0.6f),
            buttonColor = Color.White,
            buttonTextColor = Color.Gray
        ) {

        }


        MyButton(buttonText = "Next", modifier = Modifier.fillMaxWidth(0.8f)) {
            onNextClick()
        }

    }
}