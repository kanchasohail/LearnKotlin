package com.social.learnkotlin.view.reading_screen

import android.content.Context
import androidx.compose.foundation.ScrollState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.social.learnkotlin.navigation.Screens
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce

class ReadingScreenViewModel : ViewModel() {

    var totalTopics: Int = 0

    var completedTopics by mutableIntStateOf(1)

    fun onNextClick() {
        if (totalTopics > completedTopics) {
            completedTopics++
        }
    }

    fun onPreviousClick() {
        if (completedTopics > 1) {
            completedTopics--
        }
    }

}