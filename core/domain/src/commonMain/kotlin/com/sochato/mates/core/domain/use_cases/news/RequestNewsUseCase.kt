package com.sochato.mates.core.domain.use_cases.news

import com.sochato.mates.core.data.repository.NewsRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toImmutableNewsList
import com.sochato.mates.core.domain.models.WrummyDispatchers
import kotlinx.coroutines.withContext

class RequestNewsUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: NewsRepository
) : BaseUseCase(dispatchers) {
    suspend operator fun invoke() = withContext(context) {
        repository.requestNews()
            .mapCatching { it.toImmutableNewsList() }
    }
}