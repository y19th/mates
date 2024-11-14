package com.sochato.mates.core.domain.use_cases.user

import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toProfileModel
import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.local.repository.UserRepository
import kotlinx.coroutines.withContext

class ReceiveUserUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: UserRepository
): BaseUseCase(dispatchers) {
    suspend operator fun invoke(): ProfileModel = withContext(context) {
        repository.receiveUserEntity()
            ?.toProfileModel() ?: ProfileModel()
    }
}