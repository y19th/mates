package com.sochato.mates.splash.splash.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

sealed interface SplashEvents: BaseEvents {

    data object OnNavigate: SplashEvents
}