package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.extension.fetchResponse
import com.sochato.mates.core.data.model.request.FriendshipRequest
import com.sochato.mates.core.data.model.response.FriendshipResponse
import com.sochato.mates.core.data.model.response.MateResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

interface FriendsRepository {

    suspend fun requestFriends(): Result<List<FriendshipResponse>>

    suspend fun requestAllUsers(): Result<List<MateResponse>>

    suspend fun requestFriendship(request: FriendshipRequest): Result<String>
}

internal class FriendsRepositoryImpl(
    private val client: HttpClient
) : FriendsRepository {

    override suspend fun requestFriends(): Result<List<FriendshipResponse>> = runCatching {
        client.get(urlString = MatesApi.Friends).fetchResponse()
    }

    override suspend fun requestAllUsers(): Result<List<MateResponse>> = runCatching {
        client.get(urlString = MatesApi.Users).fetchResponse()
    }

    override suspend fun requestFriendship(request: FriendshipRequest): Result<String> = runCatching {
        client.post(urlString = MatesApi.RequestFriendship) {
            setBody(request)
        }.fetchResponse()
    }
}