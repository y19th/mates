package com.sochato.mates.core.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@NonRestartableComposable
@Composable
fun VerticalSpacer(
    height: Dp,
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = Modifier
            .height(height)
            .then(modifier)
    )
}

@NonRestartableComposable
@Composable
fun HorizontalSpacer(
    width: Dp,
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = Modifier
            .width(width)
            .then(modifier)
    )
}