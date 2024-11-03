package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.extension.fetchResponse
import com.sochato.mates.core.data.model.response.ProfileResponse
import io.ktor.client.request.get

interface ProfileRepository {

    suspend fun requestProfile(): Result<ProfileResponse>
}

internal class ProfileRepositoryImpl : BaseRepository(), ProfileRepository {
    override suspend fun requestProfile(): Result<ProfileResponse> = runCatching {
        client.get(urlString = MatesApi.Profile).fetchResponse()
    }
}