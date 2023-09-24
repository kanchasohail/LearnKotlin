package com.social.learnkotlin.view.editor_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun CodesCard(viewModel: EditorViewModel) {
    Text(text = viewModel.codeString)
}