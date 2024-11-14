package com.sochato.mates.core.domain.use_cases.user

import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toProfileEntity
import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.local.repository.UserRepository
import com.sochato.mates.core.util.local.MatesSettings
import kotlinx.coroutines.withContext

class UpdateUserUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: UserRepository
) : BaseUseCase(dispatchers) {
    suspend operator fun invoke(
        model: ProfileModel
    ) = withContext(context) {
        repository.updateUser(model.toProfileEntity())
            .also { MatesSettings.nickname = model.nickname }
    }
}