package com.example.githubapp.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.githubapp.R

/**
 * 読み込み中表示
 */
@Composable
fun LoadingView() {
    Text(
        text = stringResource(id = R.string.loading)
    )
}