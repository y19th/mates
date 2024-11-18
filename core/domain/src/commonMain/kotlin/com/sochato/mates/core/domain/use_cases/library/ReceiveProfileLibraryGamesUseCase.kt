package com.sochato.mates.core.domain.use_cases.library

import com.sochato.mates.core.data.repository.LibraryRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toImmutableLibraryItemModelList
import com.sochato.mates.core.domain.models.LibraryItem
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.local.repository.GameRepository
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.withContext

class ReceiveProfileLibraryGamesUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: GameRepository,
    private val libraryRepository: LibraryRepository
) : BaseUseCase(dispatchers) {
    suspend operator fun invoke(): Result<ImmutableList<LibraryItem>> = withContext(context) {
        return@withContext runCatching {
            val games = repository.select()
            libraryRepository.requestLibrary()
                .getOrThrow()
                .filter { library ->
                    games.find { game -> game.game == library.id } != null
                }.toImmutableLibraryItemModelList()
        }
    }
}