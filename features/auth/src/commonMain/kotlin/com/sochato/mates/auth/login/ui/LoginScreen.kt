package com.sochato.mates.auth.login.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sochato.mates.auth.login.domain.events.LoginEvents
import com.sochato.mates.auth.login.ui.components.LoginExpandedContent
import com.sochato.mates.core.ui.components.AppLogo
import com.sochato.mates.core.ui.components.BuildPropertiesText
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.buttons.RoundedButton
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import mates.features.auth.generated.resources.Res
import mates.features.auth.generated.resources.login_login_button
import org.jetbrains.compose.resources.stringResource


@Composable
internal fun LoginScreen(
    component: LoginComponent
) {
    val state = component.state.collectAsState()
    val handleEvents = component.rememberHandleEvents()

    WrummyColumn(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(horizontal = 24.dp)
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.3f))

        AppLogo()

        LoginExpandedContent(
            uncollectedState = state,
            handleEvents = handleEvents
        )

        Spacer(modifier = Modifier.weight(1f))

        RoundedButton(
            title = stringResource(Res.string.login_login_button),
            isLoading = state.value.isLoading,
            onClick = { handleEvents(LoginEvents.OnLogin) }
        )

        Spacer(modifier = Modifier.weight(0.1f))
    }
}