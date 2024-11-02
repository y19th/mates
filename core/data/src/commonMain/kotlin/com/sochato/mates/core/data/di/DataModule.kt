package com.sochato.mates.core.data.di

import com.sochato.mates.core.data.api.client
import com.sochato.mates.core.data.repository.RegistrationRepository
import com.sochato.mates.core.data.repository.RegistrationRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single { client }
    factoryOf(::RegistrationRepositoryImpl).bind<RegistrationRepository>()
}