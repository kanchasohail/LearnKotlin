package com.social.learnkotlin.view.profile_screen

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.social.learnkotlin.R
import com.social.learnkotlin.ui.common_views.bottomBorder
import java.io.InputStream

@Composable
fun ProfilePictureSection(
    modifier: Modifier = Modifier,
    viewModel: ProfileScreenViewModel,
    context: Context
) {
    val image = viewModel.profileImage
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            viewModel.selectedImage = uri
        }

    LaunchedEffect(Unit) {
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
            if (viewModel.selectedImage != null) {
                ImageBackdropFilter(imageResId = null, imageUri = viewModel.selectedImage)

            } else {
                ImageBackdropFilter(imageResId = image, imageUri = null)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Image(
                    painter = if (viewModel.selectedImage != null) rememberAsyncImagePainter(
                        viewModel.selectedImage
                    ) else painterResource(id = image),
                    modifier = Modifier
                        .size(150.dp)
                        .padding(8.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    contentDescription = "profile"
                )
                IconButton(
                    onClick = {
                        galleryLauncher.launch("image/*")
                    },
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

    }
}



@Composable
private fun ImageBackdropFilter(
    imageResId: Int?,
    imageUri: Uri?,
    blurRadius: Float = 20f,
) {
    val context = LocalContext.current
//    val imageBitmap = ImageBitmap.imageResource(context.resources, imageResId)
    val imageBitmap: ImageBitmap = when {
        imageResId != null -> ImageBitmap.imageResource(context.resources, imageResId)
        imageUri != null -> uriToImageBitmap(uri = imageUri)!!
        else -> throw IllegalArgumentException("Both imageResId and imageUri are null.")
    }
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
private fun uriToImageBitmap(uri: Uri): ImageBitmap? {
    val contentResolver: ContentResolver = LocalContext.current.contentResolver

    try {
        val inputStream: InputStream? = contentResolver.openInputStream(uri)
        if (inputStream != null) {
            val bitmap: Bitmap = BitmapFactory.decodeStream(inputStream)
            return bitmap.asImageBitmap()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return null
}



@Composable
private fun applyBlur(imageBitmap: ImageBitmap, radius: Float): ImageBitmap {

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
