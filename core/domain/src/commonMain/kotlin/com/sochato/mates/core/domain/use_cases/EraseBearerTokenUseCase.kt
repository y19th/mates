package com.sochato.mates.core.domain.use_cases

import com.sochato.mates.core.data.extension.tryToClearToken
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.models.WrummyDispatchers
import io.ktor.client.HttpClient
import kotlinx.coroutines.withContext

class EraseBearerTokenUseCase(
    dispatchers: WrummyDispatchers,
    private val authorizedClient: HttpClient
) : BaseUseCase(dispatchers) {
    suspend operator fun invoke() = withContext(context) {
        authorizedClient.tryToClearToken()
    }
}