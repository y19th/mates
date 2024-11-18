package com.sochato.mates.core.domain.use_cases.library

import com.sochato.mates.core.data.model.request.AddGameRequest
import com.sochato.mates.core.data.repository.LibraryRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.local.repository.GameRepository
import kotlinx.coroutines.withContext

class RequestDeleteGameFromProfileLibraryUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: LibraryRepository,
    private val gameRepository: GameRepository
) : BaseUseCase(dispatchers) {
    suspend operator fun invoke(gameId: Int) = withContext(context) {
        repository.requestDeleteGameFromProfileLibrary(
            AddGameRequest(gameId)
        ).onSuccess { gameRepository.deleteGameById(gameId) }
    }
}