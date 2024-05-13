package com.example.githubapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.model.repository.User
import com.example.githubapp.model.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * メイン画面に対するViewModel
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    /**
     * Viewの状態を表すsealed class
     */
    sealed class UiState {

        /**
         * 初期状態
         */
        data object Initial : UiState()

        /**
         * 読み込み中
         */
        data object Loading : UiState()

        /**
         * 読み込み成功
         */
        data class Success(val user: User) : UiState()

        /**
         * 読み込み失敗
         */
        data object Failure : UiState()
    }

    /**
     * Viewの状態を[UiState]として表すMutableState
     */
    val uiState: MutableState<UiState> = mutableStateOf(UiState.Initial)

    /**
     * 検索を実行する。
     *
     * searchQueryから検索フォームに入力された文字列を取得し、
     * Repositoryを経由してユーザを問い合わせる。
     */
    fun onSearchTapped(searchQuery: String) {
        viewModelScope.launch {
            uiState.value = UiState.Loading
            runCatching {
                println("searchQuery=$searchQuery")
                userRepository.getUser(userName = searchQuery)
            }.onSuccess {
                uiState.value = UiState.Success(user = it)
                println("searchQuery user=$it")
            }.onFailure {
                println("searchQuery failed $it")
                uiState.value = UiState.Failure
            }
        }
    }
}