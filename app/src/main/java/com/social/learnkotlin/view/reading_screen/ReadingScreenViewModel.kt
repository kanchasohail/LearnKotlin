package com.social.learnkotlin.view.reading_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

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