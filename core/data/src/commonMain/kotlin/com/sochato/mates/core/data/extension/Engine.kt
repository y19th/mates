package com.sochato.mates.core.data.extension

import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.authProviders
import io.ktor.client.plugins.auth.providers.BearerAuthProvider

fun HttpClient.tryToClearToken() {
    authProviders.filterIsInstance<BearerAuthProvider>()
        .firstOrNull()
        ?.clearToken()
}