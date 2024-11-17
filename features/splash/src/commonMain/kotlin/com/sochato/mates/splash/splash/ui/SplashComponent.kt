package com.sochato.mates.splash.splash.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.data.store.initializeTokenStorage
import com.sochato.mates.core.domain.use_cases.transition.ReceiveTransitionUseCase
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.core.util.local.MatesSettings
import com.sochato.mates.core.util.models.Transition
import com.sochato.mates.splash.root.RootSplashNavigator
import com.sochato.mates.splash.root.ui.RootSplashComponent
import com.sochato.mates.splash.splash.domain.events.SplashEvents
import com.sochato.mates.splash.splash.domain.state.SplashState

class SplashComponent(
    componentContext: ComponentContext,
    private val navigator: RootSplashNavigator,
    private val receiveTransition: ReceiveTransitionUseCase
) : ScreenComponent<SplashState, SplashEvents>(
    initialState = SplashState(),
    componentContext = componentContext
) {
    init {
        launchIO {
            launchIO {
                update { it.copy(transition = receiveTransition()) }
            }
            launchIO {
                initializeTokenStorage()
            }
        }
    }

    override fun handleEvent(event: SplashEvents) {
        when (event) {
            SplashEvents.OnNavigate -> {
                if (MatesSettings.onboardingCleared)
                    navigate {
                        navigator.navigate(state.value.transition ?: Transition.None)
                    }
                else
                    navigate {
                        navigator.handleConfiguration(
                            RootSplashComponent.Configuration.OnboardingConfiguration
                        )
                    }
            }
        }
    }
}