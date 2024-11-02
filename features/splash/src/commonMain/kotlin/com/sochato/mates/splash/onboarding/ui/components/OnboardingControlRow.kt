package com.sochato.mates.splash.onboarding.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sochato.mates.splash.onboarding.domain.OnboardingEvents
import mates.features.splash.generated.resources.Res
import mates.features.splash.generated.resources.onboaridng_done
import mates.features.splash.generated.resources.onboaridng_next
import mates.features.splash.generated.resources.onboaridng_skip
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun OnboardingControlRow(
    currentPage: Int,
    size: Int,
    onScroll: (newPage: Int) -> Unit,
    handleEvents: (OnboardingEvents) -> Unit
) {
    val isFinished = rememberSaveable(currentPage) {
        currentPage == size - 1
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {

        OnboardingButton(
            modifier = Modifier
                .weight(0.5f),
            text = stringResource(Res.string.onboaridng_skip),
            enabled = !isFinished,
            initialColor = Color(0x662D2B2E),
            onClick = {
                handleEvents(OnboardingEvents.OnNavigateToAuth)
            }
        )

        AnimatablePageDots(
            currentPage = currentPage,
            size = size
        )

        OnboardingButton(
            modifier = Modifier
                .weight(0.5f),
            text = stringResource(
                if (isFinished)
                    Res.string.onboaridng_done else Res.string.onboaridng_next
            ),
            initialColor = Color(0xFF2D2B2E),
            onClick = {
                if (!isFinished)
                    onScroll(currentPage.plus(1))
                else
                    handleEvents(OnboardingEvents.OnNavigateToAuth)
            }
        )
    }
}
