package com.sochato.mates.splash.ui

import com.sochato.mates.core.util.models.Transition

interface SplashNavigator {

    fun navigate(transition: Transition)
}