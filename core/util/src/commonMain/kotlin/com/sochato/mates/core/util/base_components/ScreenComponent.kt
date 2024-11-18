package com.sochato.mates.core.util.base_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.sochato.mates.core.util.local.Handler
import com.sochato.mates.core.util.local.SnackFlow
import com.sochato.mates.core.util.local.findWrummyException
import com.sochato.mates.core.util.models.SnackState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Suppress("PropertyName")
abstract class ScreenComponent<State : BaseState, in Event : BaseEvents>(
    componentContext: ComponentContext,
    initialState: State
) : BaseComponent(componentContext) {

    private val scope = coroutineScope(coroutineContext)
    private val handler = CoroutineExceptionHandler { context, throwable ->
        onCaught(throwable)
        Handler.coroutineExceptionHandler.handleException(context, throwable)
    }

    protected val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    protected fun snackEffect(state: SnackState) {
        SnackFlow.show(state)
    }

    protected open fun onCaught(throwable: Throwable) {
        SnackFlow.show(SnackState.failure(throwable.findWrummyException().message))
    }

    protected inline fun update(function: (State) -> State) {
        _state.update(function)
    }

    protected fun launch(
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return scope.launch(block = block)
    }

    protected fun launchIO(
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return scope.launch(
            context = handler + Dispatchers.IO,
            block = block
        )
    }

    abstract fun handleEvent(event: Event)
}

@Composable
fun <State : BaseState, Events : BaseEvents> ScreenComponent<State, Events>.rememberHandleEvents(): ((Events) -> Unit) {
    return remember { { this.handleEvent(it) } }
}

fun Throwable.snackState(): SnackState {
    return SnackState.failure(findWrummyException().message)
}