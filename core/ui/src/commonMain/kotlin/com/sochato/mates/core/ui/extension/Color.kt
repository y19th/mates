package com.sochato.mates.core.ui.extension

import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.sochato.mates.core.ui.theme.wrummyColorPalette

@Composable
fun ButtonDefaults.defaultColors(
    containerColor: Color = wrummyColorPalette.primaryColor,
    contentColor: Color = wrummyColorPalette.onPrimaryColor
) = buttonColors(
    containerColor = containerColor,
    contentColor = contentColor
)

@Composable
fun ButtonDefaults.textButtonDefaults() = textButtonColors(
    contentColor = wrummyColorPalette.primaryColor
)