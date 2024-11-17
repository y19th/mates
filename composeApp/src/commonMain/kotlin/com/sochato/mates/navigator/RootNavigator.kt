package com.sochato.mates.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.navigate
import com.sochato.mates.core.util.base_components.BaseNavigator
import com.sochato.mates.root.RootComponent

interface RootNavigator: BaseNavigator<RootComponent.Configuration>

internal class RootNavigatorImpl: RootNavigator {
    override val navigation: StackNavigation<RootComponent.Configuration>
        = StackNavigation()

    override fun handleConfiguration(configuration: RootComponent.Configuration) {
        navigation.navigate { listOf(configuration) }
    }
}