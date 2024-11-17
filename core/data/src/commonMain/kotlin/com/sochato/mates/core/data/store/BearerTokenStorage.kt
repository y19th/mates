package com.sochato.mates.core.data.store

import com.sochato.mates.core.local.entities.TokenEntity
import com.sochato.mates.core.local.entities.toToken
import com.sochato.mates.core.local.repository.TokenRepository
import com.sochato.mates.core.util.models.Token
import org.koin.core.component.KoinComponent
import org.koin.mp.KoinPlatform.getKoin

internal val bearerTokenStorage = mutableListOf<Token?>()

fun updateToken(token: Token?) {
    bearerTokenStorage.add(token)
}

suspend fun initializeTokenStorage() {
    updateToken(LocalTokenProvider.receive()?.toToken())
}

private class LocalTokenProvider : KoinComponent {
    companion object {
        suspend fun receive(): TokenEntity? {
            return getKoin().get<TokenRepository>().get()
        }
    }
}