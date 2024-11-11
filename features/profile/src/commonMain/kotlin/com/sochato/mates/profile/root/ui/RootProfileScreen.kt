package com.sochato.mates.profile.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.sochato.mates.profile.edit_profile.ui.EditProfileScreen
import com.sochato.mates.profile.profile.ui.ProfileScreen

@Composable
fun RootProfileScreen(
    component: RootProfileComponent
) {
    val childStack = component.childStack.subscribeAsState()

    Children(
        stack = childStack.value,
        animation = stackAnimation(slide())
    ) { child ->
        when (val instance = child.instance) {
            is RootProfileComponent.Child.ProfileChild -> {
                ProfileScreen(component = instance.component)
            }

            is RootProfileComponent.Child.EditProfileConfiguration -> {
                EditProfileScreen(component = instance.component)
            }
        }
    }
}