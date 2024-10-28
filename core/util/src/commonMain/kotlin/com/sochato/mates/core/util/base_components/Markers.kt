package com.sochato.mates.core.util.base_components

import androidx.compose.runtime.Immutable

@Immutable
interface BaseState

@Immutable
interface BaseEvents

class EmptyState private constructor(): BaseState {
    companion object {
        val Empty = EmptyState()
    }
}