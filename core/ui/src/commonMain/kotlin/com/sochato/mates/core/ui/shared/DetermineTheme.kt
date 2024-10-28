package com.sochato.mates.core.ui.shared

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import io.github.alexzhirkevich.cupertino.adaptive.Theme

expect fun determineTheme(): Theme

fun isIos() = determineTheme() == Theme.Cupertino

@Composable
fun rememberIsIos() = rememberSaveable { isIos() }