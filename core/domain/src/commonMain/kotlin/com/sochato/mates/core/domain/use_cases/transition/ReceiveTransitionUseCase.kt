package com.sochato.mates.core.domain.use_cases.transition

import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.local.repository.TransitionRepository
import com.sochato.mates.core.util.models.Transition
import kotlinx.coroutines.withContext

class ReceiveTransitionUseCase(
    dispatcher: WrummyDispatchers,
    private val repository: TransitionRepository
): BaseUseCase(dispatcher) {
    suspend operator fun invoke(): Transition = withContext(context) {
        repository.receive()
    }
}