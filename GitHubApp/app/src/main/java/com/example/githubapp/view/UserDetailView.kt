package com.example.githubapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.githubapp.model.repository.User

@Composable
fun UserDetailView(user: User) {
    Column {
        Text(
            text = user.userId.value.toString()
        )
        Text(
            text = user.name
        )
        Text(
            text = user.avatarImage.url.value
        )
        Text(
            text = user.blogUrl.value
        )
    }
}