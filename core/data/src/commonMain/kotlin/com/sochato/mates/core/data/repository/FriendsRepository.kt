package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.extension.fetchResponse
import com.sochato.mates.core.data.model.response.FriendResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get

interface FriendsRepository {

    suspend fun requestFriends(): Result<List<FriendResponse>>

    suspend fun requestAllUsers(): Result<List<FriendResponse>>
}

internal class FriendsRepositoryImpl(
    private val client: HttpClient
) : FriendsRepository {

    override suspend fun requestFriends(): Result<List<FriendResponse>> = runCatching {
        client.get(urlString = MatesApi.Friends).fetchResponse()
    }

    override suspend fun requestAllUsers(): Result<List<FriendResponse>> = runCatching {
        client.get(urlString = MatesApi.Users).fetchResponse()
    }
}