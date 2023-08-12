package com.social.learnkotlin.view.profile_screen


import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import com.social.learnkotlin.R
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class ProfileScreenViewModel : ViewModel() {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_profile")
    private val USER_NAME = stringPreferencesKey("user_name")


    var profileImage by mutableIntStateOf(R.drawable.ic_blank_profile)
    var userName by mutableStateOf("Md Sohail")

    var isEditingName by mutableStateOf(false)


    suspend fun saveUserName(context: Context) {
        context.dataStore.edit { profile ->
            profile[USER_NAME] = userName
        }
        isEditingName = false
    }


    suspend fun getUseName(context: Context) {
    val thisUserName  =  context.dataStore.data.first()[USER_NAME] ?: ""
        userName = thisUserName
    }

}