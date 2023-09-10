package com.social.learnkotlin.view.profile_screen

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import com.social.learnkotlin.R
import com.social.learnkotlin.ui.layout.DefaultFontText
import com.social.learnkotlin.ui.common_views.bottomBorder
import com.social.learnkotlin.ui.theme.RubikFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserNameSection(
    viewModel: ProfileScreenViewModel,
    context: Context,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        viewModel.getUserName(context)
    }
    Row(
        modifier = modifier
            .bottomBorder(2.dp, Color.Gray)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(.8f)) {
            DefaultFontText(
                text = "Name:",
                fontSize = 18.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold
            )
            if (viewModel.isEditingName) {
                OutlinedTextField(
                    value = viewModel.userName,
//                        value = TextFieldValue(
//                            viewModel.userName,
//                            selection = TextRange(viewModel.userName.length)
//                        ),
                    onValueChange = { viewModel.userName = it },
                    maxLines = 1,
                    textStyle = TextStyle(
                        fontSize = 22.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = RubikFontFamily
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            viewModel.isEditingName = false
                            viewModel.viewModelScope.launch {
                                viewModel.saveUserName(context)
                            }
                        }
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier.focusRequester(focusRequester)
                )
            } else {
                DefaultFontText(
                    text = viewModel.userName,
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
            DefaultFontText(
                text = "This name will be shown on your certificate!",
                fontSize = 15.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 5.dp)
            )
        }
        IconButton(
            onClick = {
                viewModel.isEditingName = !viewModel.isEditingName
                if (!viewModel.isEditingName) {
                    viewModel.viewModelScope.launch {
                        viewModel.saveUserName(context)
                    }
                }
            },
            modifier = Modifier
                .weight(.1f)
                .shadow(12.dp, ambientColor = Color.Gray, shape = CircleShape)
        ) {
            if (viewModel.isEditingName) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_save_icon),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
            } else {
                Icon(
                    imageVector = Icons.Rounded.Edit,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}