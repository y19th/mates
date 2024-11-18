package com.sochato.mates.home.news_detail.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface DetailNewsEvents: BaseEvents {

    data object OnNavigateBack: DetailNewsEvents
}