package com.sochato.mates.home.main.domain.events

import com.sochato.mates.core.domain.models.LibraryItem
import com.sochato.mates.core.util.base_components.BaseEvents
import com.sochato.mates.home.main.domain.model.MainNews

internal sealed interface MainEvents: BaseEvents {

    data object OnNavigateToProfile: MainEvents

    data object OnNavigateToAddGame: MainEvents

    data object OnFirstLaunch: MainEvents

    data object OnRefresh: MainEvents

    data object OnRefreshOnlyProfileGames: MainEvents

    data class OnNavigateToDetailGame(val model: LibraryItem): MainEvents

    data class OnNavigateToDetailNews(val model: MainNews): MainEvents

    data class OnSearchChange(val newValue: String): MainEvents
}