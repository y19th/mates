package com.sochato.mates.core.util.extension

import androidx.compose.ui.graphics.Color

fun Color.makeTransparent(alpha: Float): Color {
    return copy(alpha = alpha.coerceIn(0f..1f))
}