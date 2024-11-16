package com.sochato.mates.core.domain.use_cases.library

import com.sochato.mates.core.data.model.request.AddGameRequest
import com.sochato.mates.core.data.repository.LibraryRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toGameEntity
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.local.repository.GameRepository
import kotlinx.coroutines.withContext

class RequestAddGameToProfileLibraryUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: LibraryRepository,
    private val gameRepository: GameRepository
): BaseUseCase(dispatchers) {
    suspend operator fun invoke(gameId: Int) = withContext(context) {
        repository.requestAddGameToProfileLibrary(
            request = AddGameRequest(gameId)
        ).onSuccess {
            gameRepository.insert(it.toGameEntity())
        }
    }
}