package com.sochato.mates.core.domain

import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.util.local.Handler
import com.sochato.mates.core.util.local.message
import org.koin.core.component.KoinComponent

abstract class BaseUseCase(
    dispatcher: WrummyDispatchers
): KoinComponent {
    protected val context = dispatcher.io + Handler.coroutineExceptionHandler
    private val tag = this::class.simpleName

    protected fun message(msg: String) {
        message(tag ?: "BaseUseCase", msg)
    }
}