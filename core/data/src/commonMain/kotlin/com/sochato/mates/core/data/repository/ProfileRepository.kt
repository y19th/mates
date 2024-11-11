package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.extension.fetchResponse
import com.sochato.mates.core.data.model.request.PatchProfileRequest
import com.sochato.mates.core.data.model.response.ProfileResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.setBody

interface ProfileRepository {

    suspend fun requestProfile(): Result<ProfileResponse>

    suspend fun patchProfile(
        newNickname: String,
        newProfileDescription: String,
        newProfileImage: String?
    ): Result<ProfileResponse>
}

internal class ProfileRepositoryImpl(
    private val client: HttpClient
) : ProfileRepository {
    override suspend fun requestProfile(): Result<ProfileResponse> = runCatching {
        client.get(urlString = MatesApi.Profile).fetchResponse()
    }

    override suspend fun patchProfile(
        newNickname: String,
        newProfileDescription: String,
        newProfileImage: String?
    ): Result<ProfileResponse> = runCatching {
        client.patch(urlString = MatesApi.EditProfile) {
            val body = if (newProfileImage != null)
                PatchProfileRequest.ProfileRequestWithImage(
                    nickname = newNickname,
                    profileDescription = newProfileDescription,
                    imageUrl = newProfileImage
                )
            else
                PatchProfileRequest.ProfileRequest(
                    nickname = newNickname,
                    profileDescription = newProfileDescription
                )

            setBody(body)
        }.fetchResponse()
    }
}