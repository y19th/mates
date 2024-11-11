package com.sochato.mates.profile.root

import com.sochato.mates.core.util.base_components.BaseNavigator
import com.sochato.mates.profile.root.ui.RootProfileComponent

interface RootProfileNavigator : BaseNavigator<RootProfileComponent.Configuration> {

    fun navigateHome()

    fun logout()
}