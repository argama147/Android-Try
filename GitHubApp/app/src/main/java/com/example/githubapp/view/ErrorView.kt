package com.example.githubapp.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.githubapp.R

/**
 * エラー表示
 */
@Composable
fun ErrorView() {
    Text(
        text = stringResource(id = R.string.loading_failed)
    )
}