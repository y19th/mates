package com.sochato.mates.home.main.domain.state

import com.sochato.mates.core.domain.models.LibraryItem
import com.sochato.mates.core.domain.models.ProfileModel
import com.sochato.mates.core.util.base_components.BaseState
import com.sochato.mates.home.main.domain.model.MainNews
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.persistentMapOf

internal data class MainState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,

    val searchRequest: String = "",
    val model: ProfileModel = ProfileModel(),
    val library: ImmutableList<LibraryItem> = persistentListOf(),
    val news: ImmutableMap<String, ImmutableList<MainNews>> = persistentMapOf()
) : BaseState
