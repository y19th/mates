package com.sochato.mates.splash.onboarding.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import com.sochato.mates.splash.onboarding.ui.components.OnboardingControlRow
import com.sochato.mates.splash.onboarding.ui.components.OnboardingPage
import com.sochato.mates.splash.onboarding.ui.components.OnboardingState
import kotlinx.coroutines.launch
import mates.features.splash.generated.resources.Res
import mates.features.splash.generated.resources.icon_onboarding_first
import mates.features.splash.generated.resources.icon_onboarding_second
import mates.features.splash.generated.resources.icon_onboarding_third
import mates.features.splash.generated.resources.onboarding_first_subtitle
import mates.features.splash.generated.resources.onboarding_first_title
import mates.features.splash.generated.resources.onboarding_second_subtitle
import mates.features.splash.generated.resources.onboarding_second_title
import mates.features.splash.generated.resources.onboarding_third_subtitle
import mates.features.splash.generated.resources.onboarding_third_title
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun OnboardingScreen(
    component: OnboardingComponent
) {
    val handleEvents = component.rememberHandleEvents()
    val onboardings = rememberOnboardingState()
    val pagerState = rememberPagerState { onboardings.size }
    val coroutineScope = rememberCoroutineScope()

    WrummyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .weight(0.3f)
        )

        HorizontalPager(
            state = pagerState,
            pageSpacing = 40.dp,
            contentPadding = PaddingValues(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) { index ->
            OnboardingPage(
                state = onboardings[index]
            )
        }

        Spacer(
            modifier = Modifier
                .weight(0.4f)
        )

        OnboardingControlRow(
            currentPage = pagerState.currentPage,
            size = pagerState.pageCount,
            handleEvents = handleEvents,
            onScroll = { newPage ->
                coroutineScope.launch {
                    pagerState.animateScrollToPage(newPage)
                }
            }
        )

        Spacer(
            modifier = Modifier
                .weight(0.3f)
        )
    }
}

@Composable
internal fun rememberOnboardingState(): List<OnboardingState> {
    val items = listOf(
        OnboardingState(
            image = Res.drawable.icon_onboarding_first,
            title = stringResource(Res.string.onboarding_first_title),
            subtitle = stringResource(Res.string.onboarding_first_subtitle)
        ),
        OnboardingState(
            image = Res.drawable.icon_onboarding_second,
            title = stringResource(Res.string.onboarding_second_title),
            subtitle = stringResource(Res.string.onboarding_second_subtitle)
        ),
        OnboardingState(
            image = Res.drawable.icon_onboarding_third,
            title = stringResource(Res.string.onboarding_third_title),
            subtitle = stringResource(Res.string.onboarding_third_subtitle)
        )
    )

    return remember { items }
}