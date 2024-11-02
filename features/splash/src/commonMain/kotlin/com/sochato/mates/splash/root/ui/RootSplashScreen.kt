package com.sochato.mates.splash.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.sochato.mates.splash.onboarding.ui.OnboardingScreen
import com.sochato.mates.splash.splash.ui.SplashScreen

@Composable
fun RootSplashScreen(
    component: RootSplashComponent
) {
    val stack = component.childStack.subscribeAsState()

    Children(
        stack = stack.value,
        animation = stackAnimation(slide())
    ) { child ->
        when(val instance = child.instance) {
            is RootSplashComponent.Child.OnboardingChild -> {
                OnboardingScreen(component = instance.component)
            }
            is RootSplashComponent.Child.SplashChild -> {
                SplashScreen(component = instance.component)
            }
        }
    }
}