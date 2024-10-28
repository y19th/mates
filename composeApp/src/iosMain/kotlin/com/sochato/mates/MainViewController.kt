package com.sochato.mates

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import org.koin.core.component.KoinComponent
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackGestureOverlay
import com.arkivanov.essenty.backhandler.BackDispatcher
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import com.sochato.mates.root.RootComponent
import com.sochato.mates.root.RootScreen
import com.sochato.mates.core.util.extension.getComponent

private object KoinResolver : KoinComponent {

    fun injectRootComponent(context: ComponentContext): RootComponent =
        getComponent<RootComponent>(context)
}

@OptIn(ExperimentalDecomposeApi::class)
fun MainViewController() = ComposeUIViewController {
    val backDispatcher = BackDispatcher()
    val root = KoinResolver.injectRootComponent(
        context = DefaultComponentContext(
            lifecycle = ApplicationLifecycle(),
            backHandler = backDispatcher
        )
    )

    PredictiveBackGestureOverlay(
        backDispatcher = backDispatcher,
        backIcon = null
    ) {
        RootScreen(component = root)
    }
}