package com.example.githubapp.model.remote_data_source

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Inject

private val json = Json {
    ignoreUnknownKeys = true
}

/**
 * [ApiClient]を生成するクラス
 */
class ApiClientProvider @Inject constructor() {
    companion object {
        private const val API_END_POINT = "https://api.github.com/"
    }

    /**
     * [ApiClient]を返す
     */
    @ExperimentalSerializationApi
    fun provide(): ApiClient {
        return Retrofit.Builder()
            .baseUrl(API_END_POINT)
            .addConverterFactory(
                json.asConverterFactory(
                    "application/json".toMediaType()
                ),
            )
            .build()
            .create(ApiClient::class.java)
    }
}