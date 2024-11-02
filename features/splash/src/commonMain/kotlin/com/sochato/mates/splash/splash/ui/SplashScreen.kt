package com.sochato.mates.splash.splash.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sochato.mates.core.ui.components.AppLogo
import com.sochato.mates.core.ui.components.BuildPropertiesText
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import com.sochato.mates.core.util.models.Transition
import com.sochato.mates.splash.splash.domain.events.SplashEvents
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    component: SplashComponent
) {
    val state = component.state.collectAsState()
    val handleEvents = component.rememberHandleEvents()
    val spacerWeight = remember { Animatable(0.7f) }

    state.value.transition.let { transition ->
        LaunchedEffect(transition) {
            if (transition != null) {
                if (transition == Transition.None) {
                    delay(800)
                    spacerWeight.animateTo(
                        targetValue = 0.3f,
                        animationSpec = tween(
                            durationMillis = 800,
                            easing = LinearOutSlowInEasing
                        )
                    )
                }
                handleEvents(SplashEvents.OnNavigate)
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(spacerWeight.value))

        AppLogo()

        Spacer(modifier = Modifier.weight(1f))

        BuildPropertiesText()

        Spacer(modifier = Modifier.weight(0.1f))
    }
}