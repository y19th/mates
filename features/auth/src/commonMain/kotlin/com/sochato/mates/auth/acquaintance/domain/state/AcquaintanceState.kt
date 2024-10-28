package com.sochato.mates.auth.acquaintance.domain.state

import com.sochato.mates.core.util.base_components.BaseState

internal data class AcquaintanceState(
    val name: String = "",
    val isLoading: Boolean = false
): BaseState
