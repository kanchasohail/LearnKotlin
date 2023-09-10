package com.social.learnkotlin.view.report_problem_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.social.learnkotlin.ui.layout.DefaultFontText
import com.social.learnkotlin.ui.layout.MyButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IssueDescribingScreen(navController: NavController, selectedIssue: String) {
    val viewModel = viewModel<ReportProblemViewModel>()
    val context = LocalContext.current
    val primaryColor = MaterialTheme.colorScheme.primary

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
                title = {
                    DefaultFontText(
                        text = "Report a problem",
                        fontSize = 23.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                    }
                },
                modifier = Modifier.shadow(6.dp)
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
                .padding(paddingValues)
                .imePadding()
                .padding(12.dp),
        ) {
            var reportMessage by remember { mutableStateOf("") }

            DefaultFontText(
                text = "Share more details below",
                color = MaterialTheme.colorScheme.onSurface,
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
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                },
                colors = textFieldColors(
                    cursorColor = primaryColor,
                    focusedIndicatorColor = primaryColor,
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    textColor = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                textStyle = TextStyle(fontSize = 20.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            )
            Spacer(modifier = Modifier.weight(1f))

            MyButton(
                buttonText = "Submit",
                buttonTextColor = MaterialTheme.colorScheme.onPrimary,
                buttonColor = if (reportMessage.isEmpty()) Color.Gray else primaryColor
            ) {
                if (reportMessage.isNotEmpty()) {
                    viewModel.submitReport(selectedIssue, reportMessage, navController, context)
                }
            }

        }
    }

}