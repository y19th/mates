package com.sochato.mates.auth.forgot_password.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.sochato.mates.auth.forgot_password.domain.events.ForgotPasswordEvents
import com.sochato.mates.core.ui.components.AppLogo
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.bars.BackNavigationIcon
import com.sochato.mates.core.ui.components.bars.NavigationTopBar
import com.sochato.mates.core.ui.components.buttons.RoundedButton
import com.sochato.mates.core.ui.components.inputs.WrummyTextField
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import mates.features.auth.generated.resources.Res
import mates.features.auth.generated.resources.forgot_password_button
import mates.features.auth.generated.resources.login_login_placeholder
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ForgotPasswordScreen(
    component: ForgotPasswordComponent
) {
    val state = component.state.collectAsState()
    val handleEvents = component.rememberHandleEvents()


    WrummyColumn(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(horizontal = 24.dp)
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        topBar = {
            NavigationTopBar(
                navigationIcon = {
                    BackNavigationIcon { handleEvents(ForgotPasswordEvents.OnNavigateBack) }
                }
            )

        }
    ) {
        AppLogo()

        VerticalSpacer(height = 36.dp)

        WrummyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.value.email,
            placeholder = stringResource(Res.string.login_login_placeholder),
            keyboardType = KeyboardType.Email,
            error = state.value.isEmailError,
            onValueChange = {
                handleEvents(ForgotPasswordEvents.OnEmailChanged(it))
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        RoundedButton(
            title = stringResource(Res.string.forgot_password_button),
            isLoading = state.value.isLoading,
            onClick = { handleEvents(ForgotPasswordEvents.OnProceed) }
        )

        Spacer(modifier = Modifier.weight(0.1f))
    }

}