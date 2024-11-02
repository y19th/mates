package com.sochato.mates.core.util.shared

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp

@Composable
fun rememberScreenWidth(): Dp {
    val width = screenWidth()
    return remember { width }
}

@Composable
fun rememberScreenHeight(): Dp {
    val height = screenHeight()
    return remember { height }
}

@Composable
expect fun screenWidth(): Dp

@Composable
expect fun screenHeight(): Dp