package com.social.learnkotlin.view.bottom_and_top_bars

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BottomNavigationViewModel : ViewModel() {
    var screenTitle by mutableStateOf("Lessons")
}