package com.sochato.mates.core.domain.di

import com.sochato.mates.core.domain.models.WrummyDispatchers
import com.sochato.mates.core.domain.use_cases.transition.ReceiveTransitionUseCase
import com.sochato.mates.core.domain.use_cases.transition.UpdateTransitionUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    single { WrummyDispatchers() }
    factoryOf(::UpdateTransitionUseCase)
    factoryOf(::ReceiveTransitionUseCase)
}
