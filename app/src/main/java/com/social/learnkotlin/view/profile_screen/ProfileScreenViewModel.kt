package com.social.learnkotlin.view.profile_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.social.learnkotlin.R

class ProfileScreenViewModel : ViewModel() {
    var profileImage by mutableStateOf(R.drawable.ic_blank_profile)

}