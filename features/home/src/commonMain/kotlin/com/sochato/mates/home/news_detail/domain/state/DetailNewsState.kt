package com.sochato.mates.home.news_detail.domain.state

import com.sochato.mates.core.util.base_components.BaseState
import com.sochato.mates.home.main.domain.model.MainNews

internal data class DetailNewsState(
    val item: MainNews
): BaseState
