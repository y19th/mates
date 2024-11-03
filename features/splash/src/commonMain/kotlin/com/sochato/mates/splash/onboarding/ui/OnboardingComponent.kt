package com.sochato.mates.splash.onboarding.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.util.base_components.EventComponent
import com.sochato.mates.core.util.local.MatesSettings
import com.sochato.mates.core.util.models.Transition
import com.sochato.mates.splash.onboarding.domain.OnboardingEvents
import com.sochato.mates.splash.root.RootSplashNavigator

internal class OnboardingComponent(
    componentContext: ComponentContext,
    private val navigator: RootSplashNavigator
) : EventComponent<OnboardingEvents>(
    componentContext = componentContext
) {

    override fun handleEvent(event: OnboardingEvents) {
        when (event) {
            OnboardingEvents.OnNavigateToAuth -> {
                MatesSettings.onboardingCleared = true
                navigate { navigator.navigate(Transition.None) }
            }
        }
    }
}