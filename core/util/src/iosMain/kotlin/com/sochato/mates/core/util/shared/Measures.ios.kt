package com.sochato.mates.core.util.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIScreen

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun screenWidth(): Dp = UIScreen.mainScreen.bounds.useContents { size.width }.dp

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun screenHeight(): Dp = UIScreen.mainScreen.bounds.useContents { size.height }.dp