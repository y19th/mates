package com.sochato.mates.core.domain.use_cases

import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.local.entities.TransitionEntity
import com.sochato.mates.core.local.repository.TokenRepository
import com.sochato.mates.core.local.repository.TransitionRepository
import com.sochato.mates.core.util.models.Transition
import kotlinx.coroutines.withContext

class LogoutUseCase(
    dispatchers: WrummyDispatchers,
    private val tokenRepository: TokenRepository,
    private val transitionRepository: TransitionRepository
) : BaseUseCase(dispatchers) {
    suspend operator fun invoke() = withContext(context) {
        tokenRepository.delete()
        transitionRepository.update(TransitionEntity(step = Transition.None))
    }
}