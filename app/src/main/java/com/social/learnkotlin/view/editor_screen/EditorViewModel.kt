package com.social.learnkotlin.view.editor_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class EditorViewModel : ViewModel() {
    var isCodeScreen by mutableStateOf(true)

    var codeString by mutableStateOf("")

    fun showCodesCard() {
        isCodeScreen = true
    }

    suspend fun showOutputCard() {
        delay(1000L)
        isCodeScreen = false
    }
}