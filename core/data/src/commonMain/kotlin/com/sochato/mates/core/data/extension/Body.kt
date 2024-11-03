package com.sochato.mates.core.data.extension

import com.sochato.mates.core.util.local.WrummyException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

internal suspend fun HttpResponse.parsedBodyText(): String {
    return bodyAsText()
        .substringAfter('[')
        .substringBefore(']')
        .filter { it != '"' }

}

internal suspend fun HttpResponse.unauthorizedBody(): String {
    return body<Unauthorized>().detail
}

@Serializable
@JvmInline
internal value class Unauthorized(val detail: String)

internal suspend inline fun <reified Result> HttpResponse.fetchResponse(): Result {
    return if (status.isSuccess())
        body()
    else if (status.value == 401)
        throw WrummyException.CustomError(unauthorizedBody())
    else
        throw WrummyException.CustomError(parsedBodyText())
}