package com.sochato.mates.core.data.di

import com.sochato.mates.core.data.api.authorizedClient
import com.sochato.mates.core.data.api.authorizedQualifier
import com.sochato.mates.core.data.api.client
import com.sochato.mates.core.data.api.defaultQualifier
import com.sochato.mates.core.data.extension.authorizedClient
import com.sochato.mates.core.data.extension.defaultClient
import com.sochato.mates.core.data.extension.qualifiedSingle
import com.sochato.mates.core.data.repository.FriendsRepository
import com.sochato.mates.core.data.repository.FriendsRepositoryImpl
import com.sochato.mates.core.data.repository.LibraryRepository
import com.sochato.mates.core.data.repository.LibraryRepositoryImpl
import com.sochato.mates.core.data.repository.LoginRepository
import com.sochato.mates.core.data.repository.LoginRepositoryImpl
import com.sochato.mates.core.data.repository.NewsRepository
import com.sochato.mates.core.data.repository.NewsRepositoryImpl
import com.sochato.mates.core.data.repository.ProfileRepository
import com.sochato.mates.core.data.repository.ProfileRepositoryImpl
import com.sochato.mates.core.data.repository.RegistrationRepository
import com.sochato.mates.core.data.repository.RegistrationRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    qualifiedSingle(defaultQualifier) { client }
    qualifiedSingle(authorizedQualifier) { authorizedClient }

    factory { RegistrationRepositoryImpl(defaultClient()) }.bind<RegistrationRepository>()
    factory { LoginRepositoryImpl(defaultClient()) }.bind<LoginRepository>()
    factory { ProfileRepositoryImpl(authorizedClient()) }.bind<ProfileRepository>()
    factory { NewsRepositoryImpl(authorizedClient()) }.bind<NewsRepository>()
    factory { LibraryRepositoryImpl(authorizedClient()) }.bind<LibraryRepository>()
    factory { FriendsRepositoryImpl(authorizedClient()) }.bind<FriendsRepository>()
}
