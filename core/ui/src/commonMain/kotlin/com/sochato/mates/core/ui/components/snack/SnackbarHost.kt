package com.sochato.mates.core.ui.components.snack

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.ui.components.snack.WrummySnackbar

@Composable
fun WrummySnackbarHost(
    modifier: Modifier = Modifier,
    hostState: SnackbarHostState
) {
    SnackbarHost(
        modifier = Modifier
            .padding(horizontal = 75.dp, vertical = 8.dp)
            .windowInsetsPadding(WindowInsets.systemBars)
            .then(modifier),
        hostState = hostState
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            WrummySnackbar(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                data = it
            )
        }
    }
}