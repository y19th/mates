package com.sochato.mates.auth.acquaintance.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sochato.mates.auth.acquaintance.domain.events.AcquaintanceEvents
import com.sochato.mates.core.ui.components.AppLogo
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.buttons.RoundedButton
import com.sochato.mates.core.ui.components.inputs.WrummyTextField
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import mates.features.auth.generated.resources.Res
import mates.features.auth.generated.resources.acquaintance_name_placeholder
import mates.features.auth.generated.resources.acquaintance_proceed
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun AcquaintanceScreen(
    component: AcquaintanceComponent
) {
    val state = component.state.collectAsState()
    val handleEvents = component.rememberHandleEvents()

    WrummyColumn(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.3f))

        AppLogo()

        VerticalSpacer(height = 36.dp)

        WrummyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.value.name,
            placeholder = stringResource(Res.string.acquaintance_name_placeholder),
            onValueChange = { handleEvents(AcquaintanceEvents.OnNameChange(it)) }
        )

        Spacer(modifier = Modifier.weight(1f))

        RoundedButton(
            title = stringResource(Res.string.acquaintance_proceed),
            isLoading = state.value.isLoading,
            onClick = { handleEvents(AcquaintanceEvents.OnProceed) }
        )

        Spacer(modifier = Modifier.weight(0.1f))
    }
}