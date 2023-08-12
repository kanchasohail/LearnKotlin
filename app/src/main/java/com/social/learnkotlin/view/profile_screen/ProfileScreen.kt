package com.social.learnkotlin.view.profile_screen

import android.content.Context
import android.graphics.Bitmap
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.social.learnkotlin.R
import com.social.learnkotlin.navigation.Screens
import com.social.learnkotlin.ui.common_views.DefaultFontText
import com.social.learnkotlin.ui.common_views.TwoFloatingArchLoadingIndicator
import com.social.learnkotlin.ui.common_views.bottomBorder
import com.social.learnkotlin.ui.common_views.scaffoldGradientBg
import com.social.learnkotlin.ui.theme.RubikFontFamily
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Preview(showSystemUi = true)
@Composable
fun ProfileScreen(navController: NavController = rememberNavController()) {
//fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel = viewModel<ProfileScreenViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(scaffoldGradientBg())
    ) {
        ProfileSection(viewModel = viewModel , context = context)
        StatsSection()
        ProfilePageOptions(navController = navController)
    }

}

@Composable
private fun ProfileSection(modifier: Modifier = Modifier, viewModel: ProfileScreenViewModel , context: Context) {
    val image = viewModel.profileImage
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit){
        viewModel.getUseName(context)
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .bottomBorder(2.dp, Color.Gray)
            .padding(12.dp),
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            ImageBackdropFilter(imageResId = image)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Image(
                    painter = painterResource(id = image),
                    modifier = Modifier
                        .size(150.dp)
                        .padding(8.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    contentDescription = "profile"
                )
                IconButton(
                    onClick = {                              },
                    modifier = Modifier
                        .shadow(
                            10.dp,
                            ambientColor = Color.Gray,
//                            spotColor = Color.Gray,
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_camera),
                        contentDescription = "camera",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }


        Spacer(modifier = Modifier.height(12.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
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
                        onValueChange = { viewModel.userName = it.toString() },
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
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
            IconButton(onClick = {
                viewModel.isEditingName = !viewModel.isEditingName
                if (!viewModel.isEditingName) {
                    viewModel.viewModelScope.launch {
                        viewModel.saveUserName(context)
                    }
                }
            }) {
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
}

@Composable
private fun StatsSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column {
            TwoFloatingArchLoadingIndicator()
        }
        Column {
            TwoFloatingArchLoadingIndicator()
        }
        Column {
            TwoFloatingArchLoadingIndicator()
        }
    }
}


@Composable
fun ImageBackdropFilter(
    imageResId: Int,
    blurRadius: Float = 20f,
) {
    val context = LocalContext.current
    val imageBitmap = ImageBitmap.imageResource(context.resources, imageResId)
    val modifier = Modifier
    // Apply blur to the imageBitmap
    val blurredImageBitmap = applyBlur(imageBitmap, blurRadius)

    Image(
        bitmap = blurredImageBitmap,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.then(Modifier.fillMaxSize())
    )
}

@Composable
fun applyBlur(imageBitmap: ImageBitmap, radius: Float): ImageBitmap {

    val context = LocalContext.current
    val bitmap: Bitmap = imageBitmap.asAndroidBitmap()

    val renderScript = RenderScript.create(context)
    val input = Allocation.createFromBitmap(renderScript, bitmap)
    val output = Allocation.createTyped(renderScript, input.type)
    val blur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))

    blur.setInput(input)
    blur.setRadius(radius)
    blur.forEach(output)

    output.copyTo(bitmap)

    renderScript.destroy()

    return imageBitmap

    /*    https://developer.android.com/guide/topics/renderscript/migrate */
//    var blurredBitmap = Toolkit.blur(imageBitmap, radius)
//    return blurredBitmap

}


@Composable
private fun ProfilePageOptions(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(5) {
            OptionItem(optionName = "Report a problem", icon = R.drawable.ic_report, onClick = {
                navController.navigate(
                    Screens.IssueSelectingScreen.route
                )
            })
        }
    }
}

@Composable
private fun OptionItem(
    modifier: Modifier = Modifier,
    optionName: String,
    icon: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .bottomBorder(1.dp, Color.Gray)
            .padding(vertical = 12.dp, horizontal = 8.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            modifier = Modifier
                .size(26.dp),
            contentDescription = optionName,
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(8.dp))
        DefaultFontText(text = optionName, fontSize = 22.sp, color = Color.White)
    }

}
