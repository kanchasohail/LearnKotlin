package com.social.learnkotlin.view.reading_screen

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ReadingScreenViewModel : ViewModel() {

    var totalTopics: Int = 0

    var completedTopics by mutableIntStateOf(1)

    val listState =  mutableStateOf(LazyListState())


    fun onNextClick() {
        if (totalTopics > completedTopics) {
            // To reset the scroll offset before moving to the next lesson
            viewModelScope.launch {
                listState.value.scrollToItem(0)
            }
            completedTopics++
        }
    }

    fun onPreviousClick() {
        if (completedTopics > 1) {
            // To reset the scroll offset before moving to the next lesson
            viewModelScope.launch {
                listState.value.scrollToItem(0)
            }
            completedTopics--
        }
    }

}