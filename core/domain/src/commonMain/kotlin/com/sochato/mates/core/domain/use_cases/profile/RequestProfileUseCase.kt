package com.sochato.mates.core.domain.use_cases.profile

import com.sochato.mates.core.data.repository.ProfileRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toProfileModel
import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.domain.use_cases.user.UpdateUserUseCase
import kotlinx.coroutines.withContext

class RequestProfileUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: ProfileRepository,
    private val updateUser: UpdateUserUseCase
) : BaseUseCase(dispatchers) {
    suspend operator fun invoke(): Result<ProfileModel> = withContext(context) {
        repository.requestProfile()
            .mapCatching { it.toProfileModel() }
            .onSuccess {
                updateUser(it)
            }
    }
}