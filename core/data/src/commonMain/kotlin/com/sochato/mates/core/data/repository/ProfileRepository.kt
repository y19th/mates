package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.extension.fetchResponse
import com.sochato.mates.core.data.model.request.PatchProfileRequest
import com.sochato.mates.core.data.model.response.PatchProfilePhotoResponse
import com.sochato.mates.core.data.model.response.ProfileResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.setBody
import io.ktor.http.content.PartData

interface ProfileRepository {

    suspend fun requestProfile(): Result<ProfileResponse>

    suspend fun patchProfile(
        newNickname: String,
        newProfileDescription: String
    ): Result<ProfileResponse>

    suspend fun patchProfilePhoto(
        body: List<PartData>
    ): Result<PatchProfilePhotoResponse>
}

internal class ProfileRepositoryImpl(
    private val client: HttpClient
) : ProfileRepository {
    override suspend fun requestProfile(): Result<ProfileResponse> = runCatching {
        client.get(urlString = MatesApi.Profile).fetchResponse()
    }

    override suspend fun patchProfile(
        newNickname: String,
        newProfileDescription: String
    ): Result<ProfileResponse> = runCatching {
        client.patch(urlString = MatesApi.EditProfile) {
            val body = PatchProfileRequest(
                nickname = newNickname,
                profileDescription = newProfileDescription
            )

            setBody(body)
        }.fetchResponse()
    }

    override suspend fun patchProfilePhoto(
        body: List<PartData>
    ): Result<PatchProfilePhotoResponse> = runCatching {
        client.patch(urlString = MatesApi.UpdatePicture) {
            setBody(MultiPartFormDataContent(body))
        }.fetchResponse()
    }
}