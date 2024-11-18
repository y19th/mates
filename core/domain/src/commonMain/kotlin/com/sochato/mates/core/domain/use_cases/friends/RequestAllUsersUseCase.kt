package com.sochato.mates.core.domain.use_cases.friends

import com.sochato.mates.core.data.repository.FriendsRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toImmutableFriendsList
import com.sochato.mates.core.domain.models.WrummyDispatchers
import kotlinx.coroutines.withContext

class RequestAllUsersUseCase(
    dispatchers: WrummyDispatchers,
    private val repository: FriendsRepository
) : BaseUseCase(dispatchers) {

    suspend operator fun invoke() = withContext(context) {
        repository.requestAllUsers()
            .mapCatching { it.toImmutableFriendsList() }
    }
}