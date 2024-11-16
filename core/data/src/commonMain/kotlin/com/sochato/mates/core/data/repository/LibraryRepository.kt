package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.extension.fetchResponse
import com.sochato.mates.core.data.model.response.LibraryItemResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get

interface LibraryRepository {

    suspend fun requestLibrary(): Result<List<LibraryItemResponse>>

    suspend fun requestProfileLibrary(): Result<List<LibraryItemResponse>>
}

internal class LibraryRepositoryImpl(
    private val client: HttpClient
) : LibraryRepository {
    override suspend fun requestLibrary(): Result<List<LibraryItemResponse>> = runCatching {
        client.get(urlString = MatesApi.AllGames).fetchResponse()
    }

    override suspend fun requestProfileLibrary(): Result<List<LibraryItemResponse>> = runCatching {
        client.get(urlString = MatesApi.ProfileLibrary).fetchResponse()
    }
}