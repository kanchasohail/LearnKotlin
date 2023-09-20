package com.social.learnkotlin.view.profile_screen


import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.util.Base64
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import com.social.learnkotlin.R
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class ProfileScreenViewModel : ViewModel() {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_profile")
    private val USER_NAME = stringPreferencesKey("user_name")
    private val PROFILE_IMAGE = stringPreferencesKey("profile_image")


    var profileImage by mutableIntStateOf(R.drawable.ic_blank_profile)
    var userName by mutableStateOf("Md Sohail")

    var isEditingName by mutableStateOf(false)

    var selectedImage by mutableStateOf<Uri?>(null)


    suspend fun saveUserName(context: Context) {
        context.dataStore.edit { profile ->
            profile[USER_NAME] = userName
        }
        isEditingName = false
    }

    suspend fun getUserName(context: Context) {
        val thisUserName = context.dataStore.data.first()[USER_NAME] ?: ""
        userName = thisUserName
    }

    suspend fun saveProfileImage(context: Context) {
        if (selectedImage == null) {
            return
        }
        val imageString = imageUriToBase64(uri = selectedImage!!, context = context)
        context.dataStore.edit { profile ->
            profile[PROFILE_IMAGE] = imageString ?: "null"
        }
    }

    suspend fun getProfilePicture(context: Context) {
        val imageString = context.dataStore.data.first()[PROFILE_IMAGE] ?: ""
        if (imageString == "" || imageString == "null") {
            return
        }
        val thisImageUri =
            base64ToImageUri(base64 = imageString, context = context, fileName = "profile-image")
        if (thisImageUri != null) {
            selectedImage = thisImageUri
        }

    }


}

fun imageUriToBase64(uri: Uri, context: Context): String? {
    val contentResolver: ContentResolver = context.contentResolver

    try {
        val inputStream: InputStream? = contentResolver.openInputStream(uri)
        if (inputStream != null) {
            val buffer = ByteArray(1024)
            val outputStream = ByteArrayOutputStream()

            var bytesRead: Int
            while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                outputStream.write(buffer, 0, bytesRead)
            }

            val imageBytes: ByteArray = outputStream.toByteArray()
            inputStream.close()
            return Base64.encodeToString(imageBytes, Base64.DEFAULT)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return null
}


fun base64ToImageUri(base64: String, fileName: String, context: Context): Uri? {
    try {
        val imageBytes = Base64.decode(base64, Base64.DEFAULT)
        val outputFile = File(context.cacheDir, fileName)

        val fileOutputStream = FileOutputStream(outputFile)
        fileOutputStream.write(imageBytes)
        fileOutputStream.close()

        return Uri.fromFile(outputFile)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}