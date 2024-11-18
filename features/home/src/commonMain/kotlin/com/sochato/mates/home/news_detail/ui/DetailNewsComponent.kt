package com.sochato.mates.home.news_detail.ui

import com.arkivanov.decompose.ComponentContext
import com.sochato.mates.core.util.base_components.ScreenComponent
import com.sochato.mates.home.news_detail.domain.events.DetailNewsEvents
import com.sochato.mates.home.news_detail.domain.models.NewsConfig
import com.sochato.mates.home.news_detail.domain.models.toNews
import com.sochato.mates.home.news_detail.domain.state.DetailNewsState
import com.sochato.mates.home.root.HomeNavigator

internal class DetailNewsComponent(
    componentContext: ComponentContext,
    config: NewsConfig,
    private val homeNavigator: HomeNavigator
): ScreenComponent<DetailNewsState, DetailNewsEvents>(
    initialState = DetailNewsState(config.toNews()),
    componentContext = componentContext
) {
    override fun handleEvent(event: DetailNewsEvents) {
        when(event) {
            DetailNewsEvents.OnNavigateBack -> {
                navigate { homeNavigator.pop() }
            }
        }
    }
}