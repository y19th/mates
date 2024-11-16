package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.extension.fetchResponse
import com.sochato.mates.core.data.model.response.NewsItemResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get

interface NewsRepository {

    suspend fun requestNews(): Result<List<NewsItemResponse>>
}

internal class NewsRepositoryImpl(
    private val client: HttpClient
): NewsRepository {
    override suspend fun requestNews(): Result<List<NewsItemResponse>> = runCatching {
        client.get(urlString = MatesApi.NewsRequest).fetchResponse()
    }
}