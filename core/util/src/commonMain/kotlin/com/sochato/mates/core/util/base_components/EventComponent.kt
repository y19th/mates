package com.sochato.mates.core.util.base_components

import com.arkivanov.decompose.ComponentContext

abstract class EventComponent<Event: BaseEvents>(
    componentContext: ComponentContext
): ScreenComponent<EmptyState, Event>(
    componentContext = componentContext,
    initialState = EmptyState.Empty
)