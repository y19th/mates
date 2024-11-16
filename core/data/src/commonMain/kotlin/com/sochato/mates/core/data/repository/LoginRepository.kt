package com.sochato.mates.core.data.repository

import com.sochato.mates.core.data.api.MatesApi
import com.sochato.mates.core.data.extension.fetchResponse
import com.sochato.mates.core.data.model.request.LoginRequest
import com.sochato.mates.core.data.model.request.RefreshRequest
import com.sochato.mates.core.util.models.Token
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody

interface LoginRepository {

    suspend fun requestLogin(
        request: LoginRequest
    ): Result<Token>

    suspend fun requestRefresh(
        request: RefreshRequest
    ): Result<Token>
}

internal class LoginRepositoryImpl(
    private val client: HttpClient
) : LoginRepository {

    override suspend fun requestLogin(
        request: LoginRequest
    ): Result<Token> = runCatching {
        client.post(urlString = MatesApi.Login) {
            setBody(request)
        }.fetchResponse()
    }

    override suspend fun requestRefresh(
        request: RefreshRequest
    ): Result<Token> = runCatching {
        client.post(urlString = MatesApi.RefreshToken) {
            setBody(request)
        }.fetchResponse()
    }
}