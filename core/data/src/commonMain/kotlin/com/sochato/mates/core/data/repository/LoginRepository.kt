package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.extension.fetchResponse
import com.sochato.mates.core.data.model.request.LoginRequest
import com.sochato.mates.core.data.model.response.LoginResponse
import io.ktor.client.request.post
import io.ktor.client.request.setBody

interface LoginRepository {

    suspend fun requestLogin(
        request: LoginRequest
    ): Result<LoginResponse>
}

internal class LoginRepositoryImpl : BaseRepository(), LoginRepository {

    override suspend fun requestLogin(
        request: LoginRequest
    ): Result<LoginResponse> = runCatching {
        client.post(urlString = MatesApi.Login) {
            setBody(request)
        }.fetchResponse()
    }
}