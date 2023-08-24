package com.social.learnkotlin.view.codes_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.ui.common_views.scaffoldGradientBg

//@Preview(showSystemUi = true)
@Composable
fun CodesScreen(navController: NavController) {
//fun CodesScreen(navController: NavController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(scaffoldGradientBg())
    ) {
        LazyColumn() {
            items(5) {
                CodeFileItem(itemNumber = it , modifier = Modifier.clickable {
                    navController.navigate(Screens.EditorScreen.route)
                })
            }
        }
    }
}

@Composable
fun CodeFileItem(modifier: Modifier = Modifier, itemNumber: Int) {
    Row(
        modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(
                Brush.linearGradient(
                    listOf(
                        Color.White,
                        Color.White.copy(0.5f)
                    )
                )
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Box(
            modifier =
            Modifier
                .size(50.dp)
                .background(Color.Cyan)
                .padding(horizontal = 6.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = itemNumber.toString(), modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
        Text(text = "First.kt")
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "options")
        }

    }
}

