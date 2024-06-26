package com.example.githubapp.model.remote_data_source

/**
 * サーバーからのレスポンスを取り出すData Source
 */
interface RemoteDataSource {

    /**
     * サーバーからのレスポンスを[GitHubUser]として返す
     */
    suspend fun getGitHubUser(userName: String): GitHubUser
}