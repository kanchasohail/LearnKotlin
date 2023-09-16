package com.social.learnkotlin.view.reading_screen

import android.content.Context
import androidx.compose.foundation.ScrollState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce

class ReadingScreenViewModel(context: Context, onGoingLessonId: Int) : ViewModel() {

    private val lastCompletedTopicKey: String = "last_completed_topic$onGoingLessonId"
    private val scrollPositionKey: String = "last_scroll_position$onGoingLessonId"
    private val onGoingLessonIndexKey: String = "on_going_lesson_index"

    private val prefs by lazy {
        context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }
    private val lastCompletedTopic: Int = prefs.getInt(lastCompletedTopicKey, 1)

    var totalTopics: Int = 0

    var thisLessonIndex: Int = 0

    var completedTopics by mutableIntStateOf(lastCompletedTopic)

    val initialScrollPosition = prefs.getInt(scrollPositionKey, 0)

    @OptIn(FlowPreview::class)
    suspend fun saveScrollPosition(scrollState: ScrollState) {
        snapshotFlow {
            scrollState.value
        }.debounce(500L)
            .collectLatest { index ->
                prefs.edit()
                    .putInt(scrollPositionKey, index)
                    .apply()
            }
    }


    fun onNextClick() {
        if (totalTopics > completedTopics) {
            completedTopics++
            prefs.edit()
                .putInt(lastCompletedTopicKey, completedTopics)
                .apply()
        }
    }

    fun onPreviousClick() {
        if (completedTopics > 1) {
            completedTopics--
            prefs.edit()
                .putInt(lastCompletedTopicKey, completedTopics)
                .apply()
        }
    }

    //TODO Start the quiz
    fun onStartClick() {
        prefs.edit().putInt(onGoingLessonIndexKey, thisLessonIndex + 1).apply()
    }
}