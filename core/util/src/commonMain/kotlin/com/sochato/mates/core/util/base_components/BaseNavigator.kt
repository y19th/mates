package com.sochato.mates.core.util.base_components

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop

interface BaseNavigator<Configuration: Any> {

    val navigation: StackNavigation<Configuration>

    fun pop() { navigation.pop() }

    fun handleConfiguration(configuration: Configuration)
}