package com.sochato.mates.splash.onboarding.domain

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface OnboardingEvents: BaseEvents {

    data object OnNavigateToAuth: OnboardingEvents

}