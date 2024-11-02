package com.sochato.mates.splash.splash.domain.state

import com.sochato.mates.core.util.base_components.BaseState
import com.sochato.mates.core.util.models.Transition

data class SplashState(
    val transition: Transition? = null,
): BaseState
