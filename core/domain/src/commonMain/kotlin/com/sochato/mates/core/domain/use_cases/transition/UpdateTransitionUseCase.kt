package com.sochato.mates.core.domain.use_cases.transition

import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.local.entities.TransitionEntity
import com.sochato.mates.core.local.repository.TransitionRepository
import com.sochato.mates.core.util.models.Transition
import kotlinx.coroutines.withContext

class UpdateTransitionUseCase(
    dispatcher: WrummyDispatchers,
    private val repository: TransitionRepository
) : BaseUseCase(dispatcher) {
    suspend operator fun invoke(transition: Transition) = withContext(context) {
        repository.update(TransitionEntity(step = transition))
    }
}