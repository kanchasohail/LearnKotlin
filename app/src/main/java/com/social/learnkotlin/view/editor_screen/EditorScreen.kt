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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.social.learnkotlin.R
import kotlinx.coroutines.launch

@Composable
fun EditorScreen(navController: NavController, pCodeString: String) {
    val primaryColor: Color = MaterialTheme.colorScheme.primary
    val onPrimaryColor: Color = MaterialTheme.colorScheme.onPrimary
    val appBarContentColor = MaterialTheme.colorScheme.onBackground

    val viewModel = viewModel<EditorViewModel>()
    val scope = rememberCoroutineScope()

    SideEffect {
        viewModel.codeString = pCodeString
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(
                    MaterialTheme.colorScheme.background
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back",
                    tint = appBarContentColor
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
                            if (viewModel.isCodeScreen) primaryColor else Color.Transparent
                        )
                        .border(
                            1.dp,
                            primaryColor,
                            shape = RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp)
                        )
                        .clickable {
                            viewModel.showCodesCard()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Code",
                        color = if (viewModel.isCodeScreen) onPrimaryColor else appBarContentColor
                    )
                }

                Box(
                    modifier = Modifier
                        .height(38.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp))
                        .background(
                            if (!viewModel.isCodeScreen) primaryColor else Color.Transparent
                        )
                        .border(
                            1.dp,
                            primaryColor,
                            shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp)
                        )
                        .clickable {
                            scope.launch {
                                viewModel.showOutputCard()
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Output",
                        color = if (!viewModel.isCodeScreen) onPrimaryColor else appBarContentColor
                    )
                }
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_save_icon),
                    contentDescription = "Save",
                    tint = appBarContentColor
                )
            }

        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.primary
        )

        if (viewModel.isCodeScreen) CodesCard(viewModel) else OutputCard()
    }

}
