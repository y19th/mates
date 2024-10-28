package com.sochato.mates.core.local.di

import com.sochato.mates.core.local.dao.CarDao
import com.sochato.mates.core.local.dao.DetailDao
import com.sochato.mates.core.local.dao.TransitionDao
import com.sochato.mates.core.local.dao.UserDao
import com.sochato.mates.core.local.database.MainDatabase
import com.sochato.mates.core.local.repository.CarRepository
import com.sochato.mates.core.local.repository.CarRepositoryImpl
import com.sochato.mates.core.local.repository.DetailRepository
import com.sochato.mates.core.local.repository.DetailRepositoryImpl
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
    factory<DetailDao> { get<MainDatabase>().detailDao() }
    factory<CarDao> { get<MainDatabase>().carDao() }
    factoryOf(::TransitionRepositoryImpl).bind<TransitionRepository>()
    factoryOf(::UserRepositoryImpl).bind<UserRepository>()
    factoryOf(::DetailRepositoryImpl).bind<DetailRepository>()
    factoryOf(::CarRepositoryImpl).bind<CarRepository>()
}