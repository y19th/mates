package com.sochato.mates.core.ui.extension

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.valentinilk.shimmer.shimmer

@Composable
fun Modifier.shim(
    color: Color = wrummyColorPalette.shimColor
): Modifier {
    return this
        .shimmer()
        .background(
            color = color,
            shape = RoundedCornerShape(8.dp)
        )

}