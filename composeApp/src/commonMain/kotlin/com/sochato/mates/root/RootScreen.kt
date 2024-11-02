package com.sochato.mates.root

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.sochato.mates.auth.root.ui.AuthScreen
import com.sochato.mates.core.ui.components.snack.GlobalSnackEffect
import com.sochato.mates.core.ui.components.snack.WrummySnackbarHost
import com.sochato.mates.core.ui.theme.WrummyTheme
import com.sochato.mates.core.util.local.LocalSnackbar
import com.sochato.mates.core.util.local.MatesSettings
import com.sochato.mates.core.util.local.SnackFlow
import com.sochato.mates.core.util.models.BuildProperties
import com.sochato.mates.konfig.BuildKonfig
import com.sochato.mates.splash.root.ui.RootSplashScreen

@Composable
fun RootScreen(
    component: RootComponent
) {
    val stack = component.childStack.subscribeAsState()
    val snackbar = LocalSnackbar.current

    MatesSettings.properties = BuildProperties(
        name = BuildKonfig.appVersionName,
        code = BuildKonfig.appVersionCode
    )

    val animator = when (stack.value.active.instance) {
        is RootComponent.Child.AuthChild -> {
            fade(tween(0))
        }

        is RootComponent.Child.SplashChild -> {
            slide()
        }

        else -> {
            slide()
        }
    }

    WrummyTheme {

        GlobalSnackEffect(
            stateFlow = SnackFlow.collect()
        )

        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            snackbarHost = {
                WrummySnackbarHost(hostState = snackbar)
            }
        ) {

            Children(
                stack = stack.value,
                animation = stackAnimation(
                    animator = animator,
                    disableInputDuringAnimation = true
                )
            ) { child ->
                when (val instance = child.instance) {
                    is RootComponent.Child.SplashChild -> {
                        RootSplashScreen(component = instance.component)
                    }

                    is RootComponent.Child.AuthChild -> {
                        AuthScreen(component = instance.component)
                    }
                }
            }
        }
    }
}