package com.sochato.mates.auth.sign_up.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.sochato.mates.auth.sign_up.domain.events.SignUpEvents
import com.sochato.mates.core.ui.components.AppLogo
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.bars.BackNavigationIcon
import com.sochato.mates.core.ui.components.bars.NavigationTopBar
import com.sochato.mates.core.ui.components.buttons.RoundedButton
import com.sochato.mates.core.ui.components.inputs.PasswordWrummyTextField
import com.sochato.mates.core.ui.components.inputs.WrummyTextField
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import mates.features.auth.generated.resources.Res
import mates.features.auth.generated.resources.login_login_placeholder
import mates.features.auth.generated.resources.login_password_placeholder
import mates.features.auth.generated.resources.sign_up_button
import mates.features.auth.generated.resources.sign_up_nickname_placeholder
import mates.features.auth.generated.resources.sign_up_repeat_password_placeholder
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SignUpScreen(
    component: SignUpComponent
) {
    val state = component.state.collectAsState()
    val handleEvents = component.rememberHandleEvents()

    WrummyColumn(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        topBar = {
            NavigationTopBar(
                navigationIcon = {
                    BackNavigationIcon { handleEvents(SignUpEvents.OnNavigateBack) }
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
                handleEvents(SignUpEvents.OnEmailChange(it))
            }
        )

        VerticalSpacer(height = 16.dp)

        PasswordWrummyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.value.password,
            placeholder = stringResource(Res.string.login_password_placeholder),
            error = state.value.isPasswordError,
            onValueChange = {
                handleEvents(SignUpEvents.OnPasswordChange(it))
            }
        )

        VerticalSpacer(height = 16.dp)

        PasswordWrummyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.value.repeatPassword,
            placeholder = stringResource(Res.string.sign_up_repeat_password_placeholder),
            error = state.value.isPasswordRepeatError,
            onValueChange = {
                handleEvents(SignUpEvents.OnRepeatPasswordChange(it))
            }
        )

        VerticalSpacer(height = 24.dp)

        WrummyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.value.nickname,
            placeholder = stringResource(Res.string.sign_up_nickname_placeholder),
            error = state.value.isNicknameError,
            onValueChange = {
                handleEvents(SignUpEvents.OnNicknameChange(it))
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        RoundedButton(
            isLoading = state.value.isLoading,
            title = stringResource(Res.string.sign_up_button),
            onClick = { handleEvents(SignUpEvents.OnSignUp) }
        )

        Spacer(modifier = Modifier.weight(0.1f))
    }
}