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

class ReadingScreenViewModel(context: Context , onGoingLessonId:Int) : ViewModel() {

//    var onGoingLessonId:Int = 0 //Todo This will be dynamic
    private val lastCompletedLessonKey:String = "last_completed_lesson$onGoingLessonId"
    private val scrollPositionKey:String = "last_scroll_position$onGoingLessonId"

    private val prefs by lazy {
        context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    }
    private val lastCompletedLesson: Int = prefs.getInt(lastCompletedLessonKey, 1)

    val totalTopics: Int = 8

    //    var completedLessons = mutableStateOf(1)
    var completedTopics by mutableIntStateOf(lastCompletedLesson)

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
                .putInt(lastCompletedLessonKey, completedTopics)
                .apply()
        }
    }

    fun onPreviousClick(){
            if (completedTopics > 1) {
                completedTopics--
                prefs.edit()
                    .putInt(lastCompletedLessonKey, completedTopics)
                    .apply()
            }
    }
}