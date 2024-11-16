package com.sochato.mates.core.domain.use_cases.library

import com.sochato.mates.core.data.repository.LibraryRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toImmutableLibraryItemModelList
import com.sochato.mates.core.domain.models.WrummyDispatchers
import kotlinx.coroutines.withContext

class RequestLibraryUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: LibraryRepository
): BaseUseCase(dispatchers) {
    suspend operator fun invoke() = withContext(context) {
        repository.requestLibrary()
            .mapCatching { it.toImmutableLibraryItemModelList() }
    }
}