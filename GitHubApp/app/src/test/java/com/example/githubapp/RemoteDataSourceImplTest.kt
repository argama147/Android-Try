package com.example.githubapp

import com.example.githubapp.model.remote_data_source.ApiClientProvider
import com.example.githubapp.model.remote_data_source.RemoteDataSource
import com.example.githubapp.model.remote_data_source.RemoteDataSourceImpl
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class RemoteDataSourceImplTest {

    private val mockWebServer = MockWebServer()

    private lateinit var target: RemoteDataSource

    @Before
    fun setUp() {
        mockWebServer.start()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Test
    fun testGetGitHubUser() = runBlocking {
        mockWebServer.enqueue(MockResponse().setResponseCode(200))
        target = RemoteDataSourceImpl(ApiClientProvider().provide())
        val actual = target.getGitHubUser(userName = "argama147")
        assertNotNull(actual)
        assertEquals("argama147", actual.name)
    }
}