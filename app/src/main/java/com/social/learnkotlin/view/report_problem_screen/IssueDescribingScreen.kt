package com.social.learnkotlin.view.report_problem_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.social.learnkotlin.R
import com.social.learnkotlin.ui.common_views.DefaultFontText
import com.social.learnkotlin.ui.common_views.MyButton
import com.social.learnkotlin.ui.common_views.scaffoldGradientBg

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun IssueDescribingScreen(navController: NavController, selectedIssue: String) {
    val viewModel = viewModel<ReportProblemViewModel>()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = colorResource(id = R.color.app_bar_background),
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
                    DefaultFontText(
                        text = "Report a problem",
                        fontSize = 23.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(Modifier.height(0.dp)) {

            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(scaffoldGradientBg())
                .padding(paddingValues)
                .imePadding()
                .padding(12.dp),
        ) {
            var reportMessage by remember { mutableStateOf("") }

            DefaultFontText(
                text = "Share more details below",
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = reportMessage,
                onValueChange = { reportMessage = it },
                placeholder = {
                    DefaultFontText(
                        text = "Type here...",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                },
                colors = textFieldColors(
                    cursorColor = colorResource(id = R.color.app_bar_background),
                    focusedIndicatorColor = colorResource(id = R.color.app_bar_background)
                ),
                textStyle = TextStyle(fontSize = 20.sp, color = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(colorResource(id = R.color.text_field_bg_color))
            )
            Spacer(modifier = Modifier.weight(1f))

            MyButton(
                buttonText = "Submit",
                buttonColor = if (reportMessage.isEmpty()) Color.Gray else colorResource(id = R.color.button_color)
            ) {
                if (reportMessage.isNotEmpty()) {
                    viewModel.submitReport(selectedIssue, reportMessage, navController, context)
                }
            }

        }
    }

}