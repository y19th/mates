package com.sochato.mates.splash.onboarding.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.texts.TextRegular

@Composable
internal fun OnboardingButton(
    text: String,
    initialColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val animatedColor = animateColorAsState(
        targetValue = if (enabled) initialColor else initialColor.copy(alpha = 0f)
    )

    TextRegular(
        modifier = Modifier
            .clickable(
                onClick = onClick,
                enabled = enabled
            )
            .then(modifier),
        text = text,
        fontSize = 16.sp,
        lineHeight = 28.sp,
        letterSpacing = (-0.4).sp,
        color = animatedColor.value,
        textAlign = TextAlign.Center
    )
}
