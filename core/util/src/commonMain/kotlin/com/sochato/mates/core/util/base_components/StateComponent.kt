package com.sochato.mates.core.util.base_components

import com.arkivanov.decompose.ComponentContext

abstract class StateComponent<State: BaseState>(
    componentContext: ComponentContext,
    initialState: State
): ScreenComponent<State, Nothing>(
    componentContext = componentContext,
    initialState = initialState
) {
    override fun handleEvent(event: Nothing) = Unit
}