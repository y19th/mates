package com.sochato.mates.auth.root

import com.sochato.mates.auth.root.ui.AuthComponent
import com.sochato.mates.core.util.base_components.BaseNavigator

interface AuthNavigator: BaseNavigator<AuthComponent.Configuration> {

    fun navigateHome()
}