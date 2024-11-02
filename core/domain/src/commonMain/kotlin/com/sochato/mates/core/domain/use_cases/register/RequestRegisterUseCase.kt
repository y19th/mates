package com.sochato.mates.core.domain.use_cases.register

import com.sochato.mates.core.data.model.request.RegisterRequest
import com.sochato.mates.core.data.repository.RegistrationRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.models.WrummyDispatchers
import kotlinx.coroutines.withContext

class RequestRegisterUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: RegistrationRepository
) : BaseUseCase(dispatchers) {

    suspend operator fun invoke(
        email: String,
        password: String,
        nickname: String
    ): Result<String> = withContext(context) {
        repository.requestRegister(
            request = RegisterRequest(email, password, nickname)
        ).mapCatching { it.message }
    }
}