package com.sochato.mates.core.domain.use_cases.friends

import com.sochato.mates.core.data.repository.FriendsRepository
import com.sochato.mates.core.domain.BaseUseCase
import com.sochato.mates.core.domain.mapper.toImmutableFriendsList
import com.sochato.mates.core.domain.models.WrummyDispatchers
import kotlinx.coroutines.withContext

class RequestFriendsUseCase(
    dispatchers: WrummyDispatchers,
    private val friendsRepository: FriendsRepository
) : BaseUseCase(dispatchers) {

    suspend operator fun invoke() = withContext(context) {
        friendsRepository.requestFriends()
            .mapCatching { it.toImmutableFriendsList() }
    }
}