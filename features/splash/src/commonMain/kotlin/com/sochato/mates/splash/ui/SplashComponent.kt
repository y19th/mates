package com.sochato.mates.splash.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.domain.use_cases.transition.ReceiveTransitionUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.models.Transition
import com.sochato.mates.splash.domain.events.SplashEvents
import com.sochato.mates.splash.domain.state.SplashState

class SplashComponent(
    componentContext: ComponentContext,
    private val navigator: SplashNavigator,
    private val receiveTransition: ReceiveTransitionUseCase
) : ScreenComponent<SplashState, SplashEvents>(
    initialState = SplashState(),
    componentContext = componentContext
) {
    init {
        launchIO { update { it.copy(transition = receiveTransition()) } }
    }

    override fun handleEvent(event: SplashEvents) {
        when (event) {
            SplashEvents.OnNavigate -> {
                navigate {
                    navigator.navigate(state.value.transition ?: Transition.None)
                }

            }
        }
    }
}