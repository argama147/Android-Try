package com.example.githubapp.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.githubapp.R

/**
 * 検索キーワードの入力フォームと検索実行ボタンの表示
 */
@Composable
fun SearchView(
    onSearchButtonTapped: (searchQuery: String) -> Unit
) {
    Row(Modifier.fillMaxWidth()) {
        var nowSearchQuery by remember {
            mutableStateOf("")
        }
        TextField(
            label = {
                Text(stringResource(id = R.string.enter_gitHub_account))
            },
            value = nowSearchQuery,
            onValueChange = { text ->
                nowSearchQuery = text
            },
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = {
                onSearchButtonTapped(nowSearchQuery)
            }
        ) {
            Text(
                text = stringResource(id = R.string.search)
            )
        }
    }
}