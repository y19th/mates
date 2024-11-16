package com.sochato.mates.home.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.sochato.mates.home.add_game.ui.AddGameScreen
import com.sochato.mates.home.game_detail.ui.DetailGameScreen
import com.sochato.mates.home.main.ui.MainScreen
import com.sochato.mates.profile.root.ui.RootProfileScreen

@Composable
fun HomeScreen(
    component: HomeComponent
) {
    val stack = component.childStack.subscribeAsState()

    Children(
        stack = stack.value,
        animation = stackAnimation(slide())
    ) { child ->
        when (val instance = child.instance) {
            is HomeComponent.Child.MainChild -> {
                MainScreen(component = instance.component)
            }

            is HomeComponent.Child.ProfileChild -> {
                RootProfileScreen(component = instance.component)
            }

            is HomeComponent.Child.AddGameChild -> {
                AddGameScreen(component = instance.component)
            }

            is HomeComponent.Child.DetailGameChild -> {
                DetailGameScreen(component = instance.component)
            }
        }
    }
}