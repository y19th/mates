package com.sochato.mates.core.domain.use_cases.login

import com.sochato.mates.core.data.model.request.LoginRequest
import com.sochato.mates.core.data.model.response.LoginResponse
import com.sochato.mates.core.data.repository.LoginRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toTokenEntity
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.local.repository.TokenRepository
import com.sochato.mates.core.util.local.MatesSettings
import com.sochato.mates.core.util.local.debugMessage
import com.sochato.mates.core.util.models.Token
import kotlinx.coroutines.withContext

class RequestLoginUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: LoginRepository,
    private val tokenRepository: TokenRepository
) : BaseUseCase(dispatchers) {

    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<LoginResponse> = withContext(context) {
        repository.requestLogin(
            request = LoginRequest(email, password)
        ).onSuccess {
            tokenRepository.insert(it.toTokenEntity())
            MatesSettings.token = Token(it.access, it.refresh)
        }.onFailure {
            debugMessage(it.stackTraceToString())
        }
    }
}