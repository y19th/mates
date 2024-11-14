package com.sochato.mates.core.util.base_components

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


abstract class EffectComponent<State : BaseState, Events : BaseEvents, Effect : BaseEffect>(
    initialState: State,
    componentContext: ComponentContext
) : ScreenComponent<State, Events>(
    initialState = initialState,
    componentContext = componentContext
) {
    private val _sideEffects: MutableStateFlow<Effect?> = MutableStateFlow(null)
    val sideEffects = _sideEffects.asStateFlow()

    protected fun sideEffect(effect: Effect) {
        _sideEffects.value = effect
    }
}