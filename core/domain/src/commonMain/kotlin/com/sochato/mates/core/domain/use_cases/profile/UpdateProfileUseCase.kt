package com.sochato.mates.core.domain.use_cases.profile

import com.sochato.mates.core.data.repository.ProfileRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toProfileModel
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.domain.use_cases.user.UpdateUserUseCase
import kotlinx.coroutines.withContext

class UpdateProfileUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: ProfileRepository,
    private val updateUser: UpdateUserUseCase
) : BaseUseCase(dispatchers) {
    suspend operator fun invoke(
        nickname: String,
        description: String,
        imageUrl: String?
    ) = withContext(context) {
        repository.patchProfile(
            newNickname = nickname,
            newProfileDescription = description,
            newProfileImage = imageUrl
        ).mapCatching { it.toProfileModel() }
            .onSuccess { updateUser(it) }
    }
}