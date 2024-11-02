package com.sochato.mates.splash.root

import com.sochato.mates.core.util.base_components.BaseNavigator
import com.sochato.mates.core.util.models.Transition
import com.sochato.mates.splash.root.ui.RootSplashComponent

interface RootSplashNavigator: BaseNavigator<RootSplashComponent.Configuration> {

    fun navigate(transition: Transition)
}