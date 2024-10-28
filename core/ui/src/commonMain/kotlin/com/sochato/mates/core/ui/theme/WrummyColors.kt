package com.sochato.mates.core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val wrummyColorPalette: WrummyColors
    @Composable
    get() = LocalWrummyColors.current

val LocalWrummyColors = staticCompositionLocalOf { wrummyColorPalette() }

data class WrummyColors(
    val primaryColor: Color,
    val onPrimaryColor: Color,
    val primaryTextColor: Color,
    val secondaryTextColor: Color,
    val tertiaryTextColor: Color,
    val placeholderTextColor: Color,
    val homePrimaryColor: Color,
    val homeSecondaryTextColor: Color,
    val outlineColor: Color,
    val onOutlineColor: Color,
    val hintColor: Color,
    val shimColor: Color
)

private fun wrummyColorPalette(): WrummyColors = WrummyColors(
    primaryColor = PrimaryColor,
    onPrimaryColor = OnPrimaryColor,
    primaryTextColor = PrimaryTextColor,
    secondaryTextColor = SecondaryTextColor,
    tertiaryTextColor = TertiaryTextColor,
    placeholderTextColor = PlaceholderTextColor,
    homePrimaryColor = HomePrimaryColor,
    homeSecondaryTextColor = HomeSecondaryTextColor,
    outlineColor = OutlineColor,
    onOutlineColor = OnOutlineColor,
    hintColor = HintColor,
    shimColor = ShimColor
)