package com.social.learnkotlin.view.report_problem_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.social.learnkotlin.ui.layout.DefaultFontText

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun IssueSelectingScreen(navController: NavController = rememberNavController()) {
    val viewModel = viewModel<ReportProblemViewModel>()
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
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IssueSelectingCard(viewModel = viewModel, navController)
        }
    }

}

@Composable
private fun IssueSelectingCard(viewModel: ReportProblemViewModel, navController: NavController) {
    val textColor = MaterialTheme.colorScheme.onBackground
    DefaultFontText(
        text = "What do you want to share with us?",
        fontSize = 30.sp,
        lineHeight = 40.sp,
        textAlign = TextAlign.Center,
        color = textColor
    )
    Spacer(modifier = Modifier.height(5.dp))
    ReportTileItem(
        text = viewModel.TECHNICAL_ISSUE,
        onClick = {
            viewModel.onIssueSelect(
                viewModel.TECHNICAL_ISSUE,
                navController = navController
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
    ReportTileItem(
        text = viewModel.BAD_EXPERIENCCE,
        onClick = {
            viewModel.onIssueSelect(
                viewModel.BAD_EXPERIENCCE,
                navController = navController
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
    ReportTileItem(
        text = viewModel.SUGGESTION,
        onClick = { viewModel.onIssueSelect(viewModel.SUGGESTION, navController = navController) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
    ReportTileItem(
        text = viewModel.OTHER,
        onClick = { viewModel.onIssueSelect(viewModel.OTHER, navController = navController) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
private fun ReportTileItem(
    text: String,
    modifier: Modifier = Modifier,
    buttonColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            buttonColor
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        DefaultFontText(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier.padding(vertical = 3.dp)
        )
    }
}