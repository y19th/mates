package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.extension.fetchResponse
import com.sochato.mates.core.data.model.request.RegisterRequest
import com.sochato.mates.core.data.model.response.RegisterResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody

interface RegistrationRepository {

    suspend fun requestRegister(request: RegisterRequest): Result<RegisterResponse>
}

internal class RegistrationRepositoryImpl(
    private val client: HttpClient
) : RegistrationRepository {

    override suspend fun requestRegister(
        request: RegisterRequest
    ): Result<RegisterResponse> = runCatching {
        client.post(urlString = MatesApi.Register) {
            setBody(request)
        }.fetchResponse()
    }
}