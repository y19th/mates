package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.extension.fetchResponse
import com.sochato.mates.core.data.model.request.AddGameRequest
import com.sochato.mates.core.data.model.response.GameResponse
import com.sochato.mates.core.data.model.response.LibraryItemResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

interface LibraryRepository {

    suspend fun requestLibrary(): Result<List<LibraryItemResponse>>

    suspend fun requestAddGameToProfileLibrary(
        request: AddGameRequest
    ): Result<GameResponse>

    suspend fun requestProfileLibrary(): Result<List<GameResponse>>
}

internal class LibraryRepositoryImpl(
    private val client: HttpClient
) : LibraryRepository {
    override suspend fun requestLibrary(): Result<List<LibraryItemResponse>> = runCatching {
        client.get(urlString = MatesApi.AllGames).fetchResponse()
    }

    override suspend fun requestAddGameToProfileLibrary(
        request: AddGameRequest
    ): Result<GameResponse> = runCatching {
        client.post(urlString = MatesApi.ProfileLibrary) {
            setBody(request)
        }.fetchResponse()
    }

    override suspend fun requestProfileLibrary(): Result<List<GameResponse>> = runCatching {
        client.get(urlString = MatesApi.ProfileLibrary).fetchResponse()
    }
}