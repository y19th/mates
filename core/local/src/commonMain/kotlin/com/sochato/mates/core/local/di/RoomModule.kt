package com.sochato.mates.core.local.di

import com.sochato.mates.core.local.dao.GameDao
import com.sochato.mates.core.local.dao.TokenDao
import com.sochato.mates.core.local.dao.TransitionDao
import com.sochato.mates.core.local.dao.UserDao
import com.sochato.mates.core.local.database.MainDatabase
import com.sochato.mates.core.local.repository.GameRepository
import com.sochato.mates.core.local.repository.GameRepositoryImpl
import com.sochato.mates.core.local.repository.TokenRepository
import com.sochato.mates.core.local.repository.TokenRepositoryImpl
import com.sochato.mates.core.local.repository.TransitionRepository
import com.sochato.mates.core.local.repository.TransitionRepositoryImpl
import com.sochato.mates.core.local.repository.UserRepository
import com.sochato.mates.core.local.repository.UserRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val roomModule = module {
    factory<TransitionDao> { get<MainDatabase>().transitionDao() }
    factory<UserDao> { get<MainDatabase>().userDao() }
    factory<TokenDao> { get<MainDatabase>().tokenDao() }
    factory<GameDao> { get<MainDatabase>().gameDao() }
    factoryOf(::TransitionRepositoryImpl).bind<TransitionRepository>()
    factoryOf(::UserRepositoryImpl).bind<UserRepository>()
    factoryOf(::TokenRepositoryImpl).bind<TokenRepository>()
    factoryOf(::GameRepositoryImpl).bind<GameRepository>()
}