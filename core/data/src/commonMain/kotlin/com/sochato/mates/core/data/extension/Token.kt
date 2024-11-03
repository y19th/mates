package com.sochato.mates.core.data.extension

import com.sochato.mates.core.local.entities.TokenEntity
import io.ktor.client.plugins.auth.providers.BearerTokens

internal fun TokenEntity.bearer(): BearerTokens? {
    return if (access.isEmpty() || refresh.isEmpty())
        null
    else
        BearerTokens(access, refresh)
}