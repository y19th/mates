package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.model.request.RegisterRequest
import com.sochato.mates.core.data.model.response.RegisterResponse
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

interface RegistrationRepository {

    suspend fun requestRegister(request: RegisterRequest): Result<RegisterResponse>
}

internal class RegistrationRepositoryImpl : BaseRepository(), RegistrationRepository {

    override suspend fun requestRegister(
        request: RegisterRequest
    ): Result<RegisterResponse> = runCatching {
        client.post(urlString = MatesApi.Register) {
            setBody(request)
            /*parameter("email", request.email)
            parameter("password", request.password)
            parameter("nickname", request.nickname)*/
        }.body()
    }
}