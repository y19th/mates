package com.sochato.mates.core.domain.use_cases.library

import com.sochato.mates.core.data.repository.LibraryRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toGameEntityList
import com.sochato.mates.core.domain.mapper.toImmutableLibraryItemModelList
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.local.repository.GameRepository
import kotlinx.coroutines.withContext

class RequestProfileLibraryUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: LibraryRepository,
    private val gameRepository: GameRepository
) : BaseUseCase(dispatchers) {
    suspend operator fun invoke() = withContext(context) {
        repository.requestProfileLibrary()
            .onSuccess {
                gameRepository.insertAll(it.toGameEntityList())
            }
            .mapCatching { games ->
                repository.requestLibrary()
                    .getOrThrow()
                    .filter { library ->
                        games.find { game -> game.game == library.id } != null
                    }.toImmutableLibraryItemModelList()
            }
    }
}