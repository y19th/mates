package com.sochato.mates.core.domain.di

import com.sochato.mates.core.data.extension.authorizedClient
import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.domain.use_cases.EraseBearerTokenUseCase
import com.sochato.mates.core.domain.use_cases.LogoutUseCase
import com.sochato.mates.core.domain.use_cases.friends.RequestAllUsersUseCase
import com.sochato.mates.core.domain.use_cases.friends.RequestFriendsUseCase
import com.sochato.mates.core.domain.use_cases.library.ReceiveProfileLibraryGamesUseCase
import com.sochato.mates.core.domain.use_cases.library.RequestAddGameToProfileLibraryUseCase
import com.sochato.mates.core.domain.use_cases.library.RequestDeleteGameFromProfileLibraryUseCase
import com.sochato.mates.core.domain.use_cases.library.RequestLibraryUseCase
import com.sochato.mates.core.domain.use_cases.library.RequestProfileLibraryUseCase
import com.sochato.mates.core.domain.use_cases.login.RequestLoginUseCase
import com.sochato.mates.core.domain.use_cases.news.RequestNewsUseCase
import com.sochato.mates.core.domain.use_cases.profile.RequestProfileUseCase
import com.sochato.mates.core.domain.use_cases.profile.UpdateProfileUseCase
import com.sochato.mates.core.domain.use_cases.register.RequestRegisterUseCase
import com.sochato.mates.core.domain.use_cases.transition.ReceiveTransitionUseCase
import com.sochato.mates.core.domain.use_cases.transition.UpdateTransitionUseCase
import com.sochato.mates.core.domain.use_cases.user.ReceiveUserUseCase
import com.sochato.mates.core.domain.use_cases.user.UpdateUserUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    single { WrummyDispatchers() }
    factoryOf(::UpdateTransitionUseCase)
    factoryOf(::ReceiveTransitionUseCase)
    factoryOf(::RequestRegisterUseCase)
    factoryOf(::RequestLoginUseCase)
    factoryOf(::RequestProfileUseCase)
    factoryOf(::LogoutUseCase)
    factoryOf(::UpdateProfileUseCase)
    factoryOf(::ReceiveUserUseCase)
    factoryOf(::UpdateUserUseCase)
    factoryOf(::RequestNewsUseCase)
    factoryOf(::RequestProfileLibraryUseCase)
    factoryOf(::RequestLibraryUseCase)
    factoryOf(::RequestAddGameToProfileLibraryUseCase)
    factoryOf(::RequestDeleteGameFromProfileLibraryUseCase)
    factoryOf(::ReceiveProfileLibraryGamesUseCase)
    factoryOf(::RequestFriendsUseCase)
    factoryOf(::RequestAllUsersUseCase)
    factory {
        EraseBearerTokenUseCase(
            dispatchers = get(),
            authorizedClient = authorizedClient()
        )
    }
}
