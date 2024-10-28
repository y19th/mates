package com.sochato.mates.auth.login.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.auth.login.domain.events.LoginEvents
import com.sochato.mates.auth.login.domain.state.LoginState
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.inputs.PasswordWrummyTextField
import com.sochato.mates.core.ui.components.inputs.WrummyTextField
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.util.extension.noIndicationClickable
import mates.features.auth.generated.resources.Res
import mates.features.auth.generated.resources.login_forgot_password
import mates.features.auth.generated.resources.login_login_placeholder
import mates.features.auth.generated.resources.login_password_placeholder
import mates.features.auth.generated.resources.login_sign_in
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun LoginExpandedContent(
    uncollectedState: State<LoginState>,
    handleEvents: (LoginEvents) -> Unit
) {
    val state = uncollectedState.value

    Column {

        VerticalSpacer(height = 36.dp)

        WrummyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.email,
            placeholder = stringResource(Res.string.login_login_placeholder),
            keyboardType = KeyboardType.Email,
            error = state.isEmailError,
            onValueChange = {
                handleEvents(LoginEvents.OnEmailChanged(it))
            }
        )

        VerticalSpacer(height = 16.dp)

        PasswordWrummyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.password,
            placeholder = stringResource(Res.string.login_password_placeholder),
            error = state.isPasswordError,
            onValueChange = {
                handleEvents(LoginEvents.OnPasswordChanged(it))
            }
        )

        VerticalSpacer(height = 16.dp)

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextRegular(
                modifier = Modifier
                    .noIndicationClickable { handleEvents(LoginEvents.OnForgotPassword) },
                text = stringResource(Res.string.login_forgot_password),
                fontSize = 12.sp
            )
            TextRegular(
                modifier = Modifier
                    .noIndicationClickable { handleEvents(LoginEvents.OnSignUp) },
                text = stringResource(Res.string.login_sign_in),
                fontSize = 12.sp
            )
        }
    }

}