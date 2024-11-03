package com.sochato.mates.core.data.api

import com.sochato.mates.core.util.local.LoggerLevel
import com.sochato.mates.core.util.local.MatesSettings
import com.sochato.mates.core.util.local.message
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal actual val authorizedClient: HttpClient = HttpClient(Darwin) {
    install(HttpTimeout) {
        socketTimeoutMillis = 60_000
        requestTimeoutMillis = 60_000
    }

    defaultRequest {
        header("Content-Type", "application/json")
        url(MatesApi.BaseUrl)

    }
    install(Auth) {
        bearer {
            loadTokens {
                MatesSettings.token.let {
                    BearerTokens(it.access, it.refresh)
                }
            }
        }
    }

    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
            explicitNulls = true
        })
    }
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                message(
                    tag = "HttpClient(OkHttp)",
                    message = message,
                    level = LoggerLevel.Verbose
                )
            }
        }
        level = if (MatesSettings.properties.debug) LogLevel.INFO else LogLevel.NONE
    }
    //install(PlutoKtorInterceptor)
}