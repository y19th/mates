package com.sochato.mates.auth.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.sochato.mates.auth.acquaintance.ui.AcquaintanceScreen
import com.sochato.mates.auth.forgot_password.ui.ForgotPasswordScreen
import com.sochato.mates.auth.login.ui.LoginScreen
import com.sochato.mates.auth.sign_up.ui.SignUpScreen

@Composable
fun AuthScreen(
    component: AuthComponent
) {
    val stack = component.childStack.subscribeAsState()

    Children(
        stack = stack.value,
        animation = stackAnimation(
            animator = slide(),
            disableInputDuringAnimation = true
        )
    ) { child ->
        when (val instance = child.instance) {
            is AuthComponent.Child.LoginChild -> {
                LoginScreen(component = instance.component)
            }

            is AuthComponent.Child.SignUpChild -> {
                SignUpScreen(component = instance.component)
            }

            is AuthComponent.Child.ForgotPasswordChild -> {
                ForgotPasswordScreen(component = instance.component)
            }

            is AuthComponent.Child.AcquaintanceChild -> {
                AcquaintanceScreen(component = instance.component)
            }
        }
    }
}