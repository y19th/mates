package com.sochato.mates.splash.onboarding.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.texts.TextMedium
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.util.shared.rememberScreenHeight
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun OnboardingPage(
    state: OnboardingState,
    modifier: Modifier = Modifier
) {
    val height = rememberScreenHeight()
    val pageHeight = remember { height / 1.7f }

    Column(
        modifier = Modifier
            .height(pageHeight)
            .padding(horizontal = 12.dp)
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(220.dp),
            painter = painterResource(state.image),
            contentDescription = null
        )

        VerticalSpacer(height = 48.dp)

        TextMedium(
            text = state.title,
            fontSize = 24.sp,
            lineHeight = 34.sp,
            letterSpacing = (-0.8).sp,
            color = Color(0xFF2D2B2E),
            textAlign = TextAlign.Center
        )

        VerticalSpacer(height = 12.dp)

        TextRegular(
            text = state.subtitle,
            fontSize = 14.sp,
            lineHeight = 24.sp,
            letterSpacing = (-0.3).sp,
            color = Color(0xFF8F8F8F),
            textAlign = TextAlign.Center
        )
    }
}

internal data class OnboardingState(
    val image: DrawableResource,
    val title: String,
    val subtitle: String
)