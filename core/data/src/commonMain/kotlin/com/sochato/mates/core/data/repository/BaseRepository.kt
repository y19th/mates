package com.sochato.mates.core.data.repository

import io.ktor.client.HttpClient
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

open class BaseRepository : KoinComponent {
    val client: HttpClient = get()
}