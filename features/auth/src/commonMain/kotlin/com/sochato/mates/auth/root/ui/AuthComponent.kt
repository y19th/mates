package com.sochato.mates.auth.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.sochato.mates.auth.acquaintance.ui.AcquaintanceComponent
import com.sochato.mates.auth.forgot_password.ui.ForgotPasswordComponent
import com.sochato.mates.auth.login.ui.LoginComponent
import com.sochato.mates.auth.root.AuthNavigator
import com.sochato.mates.auth.sign_up.ui.SignUpComponent
import com.sochato.mates.core.util.base_components.BaseComponent
import com.sochato.mates.core.util.extension.getComponent
import kotlinx.serialization.Serializable

class AuthComponent(
    componentContext: ComponentContext,
    navigator: AuthNavigator
) : BaseComponent(componentContext) {

    val childStack = childStack(
        source = navigator.navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.LoginConfiguration,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: Configuration,
        context: ComponentContext
    ): Child = when (configuration) {
        Configuration.LoginConfiguration -> {
            Child.LoginChild(getComponent(context))
        }

        Configuration.SignUpConfiguration -> {
            Child.SignUpChild(getComponent(context))
        }

        Configuration.ForgotPasswordConfiguration -> {
            Child.ForgotPasswordChild(getComponent(context))
        }

        Configuration.AcquaintanceConfiguration -> {
            Child.AcquaintanceChild(getComponent(context))
        }
    }

    sealed class Child {

        internal data class SignUpChild(val component: SignUpComponent) : Child()

        internal data class LoginChild(val component: LoginComponent) : Child()

        internal data class ForgotPasswordChild(val component: ForgotPasswordComponent) : Child()

        internal data class AcquaintanceChild(val component: AcquaintanceComponent) : Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object LoginConfiguration : Configuration()

        @Serializable
        data object SignUpConfiguration : Configuration()

        @Serializable
        data object ForgotPasswordConfiguration : Configuration()

        @Serializable
        data object AcquaintanceConfiguration : Configuration()
    }
}