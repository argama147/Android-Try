package com.example.githubapp.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.githubapp.R

/**
 * 初期表示
 */
@Composable
fun InitialView() {
    Text(
        text = stringResource(id = R.string.please_search)
    )
}