package com.social.learnkotlin.view.quiz_screen

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable

@Composable
fun RoundedCheckbox(isChecked: Boolean, onChanged: () -> Unit) {
    Checkbox(checked = isChecked, onCheckedChange = { onChanged() })
}