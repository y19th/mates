package com.sochato.mates.core.data.extension

import com.sochato.mates.core.data.api.authorizedQualifier
import com.sochato.mates.core.data.api.defaultQualifier
import io.ktor.client.HttpClient
import org.koin.core.definition.Definition
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

internal inline fun <reified T> Module.qualifiedSingle(
    qualifier: String,
    noinline definition: Definition<T>,
) {
    single(
        qualifier = named(qualifier),
        definition = definition
    )
}

internal fun Scope.authorizedClient() = get<HttpClient>(qualifier = named(authorizedQualifier))

internal fun Scope.defaultClient() = get<HttpClient>(qualifier = named(defaultQualifier))