package com.sochato.mates.core.util.extension

import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.shaped(
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    borderWidth: Dp = 1.dp,
    borderColor: Color = MaterialTheme.colorScheme.outline,
    shape: RoundedCornerShape = RoundedCornerShape(12.dp)
): Modifier {
    return this.background(
        color = backgroundColor,
        shape = shape
    ).border(
        width = borderWidth,
        color = borderColor,
        shape = shape
    ).clip(shape)
}

@Composable
fun Modifier.noIndicationClickable(
    indication: Indication? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
): Modifier = clickable(
    indication = indication,
    interactionSource = interactionSource,
    onClick = onClick
)