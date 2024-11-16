package com.sochato.mates.home.main.domain.events

import com.sochato.mates.core.util.base_components.BaseEvents

internal sealed interface MainEvents: BaseEvents {

    data object OnNavigateToProfile: MainEvents

    data object OnNavigateToAddGame: MainEvents

    data object OnFirstLaunch: MainEvents

    data object OnRefresh: MainEvents

    data class OnSearchChange(val newValue: String): MainEvents
}