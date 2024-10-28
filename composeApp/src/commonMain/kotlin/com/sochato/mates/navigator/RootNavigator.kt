package com.sochato.mates.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.replaceAll
import com.sochato.mates.root.RootComponent
import com.sochato.mates.core.util.base_components.BaseNavigator

interface RootNavigator: BaseNavigator<RootComponent.Configuration>

internal class RootNavigatorImpl: RootNavigator {
    override val navigation: StackNavigation<RootComponent.Configuration>
        = StackNavigation()

    override fun handleConfiguration(configuration: RootComponent.Configuration) {
        navigation.replaceAll(configuration)
    }
}