package com.sochato.mates.core.domain.use_cases.profile

import com.sochato.mates.core.data.repository.ProfileRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toProfileModel
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.domain.use_cases.user.UpdateUserUseCase
import io.ktor.client.request.forms.FormPart
import io.ktor.client.request.forms.formData
import kotlinx.coroutines.withContext

class UpdateProfileUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: ProfileRepository,
    private val updateUser: UpdateUserUseCase
) : BaseUseCase(dispatchers) {
    suspend operator fun invoke(
        nickname: String,
        description: String,
        imagePart: FormPart<ByteArray>?
    ) = withContext(context) {
        if (imagePart != null)
            repository.patchProfilePhoto(
                body = formData {
                    append(imagePart)
                }
            ).onFailure { throw it }

        repository.patchProfile(
            newNickname = nickname,
            newProfileDescription = description
        ).mapCatching {
            it.toProfileModel()
        }.onSuccess { updateUser(it) }
    }
}