package com.sochato.mates.profile.shared

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.net.toUri
import io.ktor.client.request.forms.FormPart
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent.getKoin
import java.io.ByteArrayOutputStream
import java.io.File
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

actual fun decodeBitmap(uri: String): ByteArray {
    File(uri).let { bitmapFile ->
        if (bitmapFile.exists())
            return bitmapFile.readBytes()
        else
            throw IllegalStateException("file not found")
    }
}

@OptIn(ExperimentalUuidApi::class)
actual fun imageAsFormData(uri: String): FormPart<ByteArray> {
    if (uri.contains("content")) {
        BitmapResolver().resolve(uri).let { byteArray: ByteArray? ->
            if (byteArray != null) {
                return FormPart(
                    key = "profile_picture",
                    value = byteArray,
                    headers = Headers.build {
                        append(HttpHeaders.ContentType, "image/*")
                        append(HttpHeaders.ContentDisposition, "filename=\"image${Uuid.random()}.jpeg\"")
                    }
                )
            } else {
                throw IllegalStateException("bitmap not found")
            }
        }
    } else {
        File(uri).let { bitmapFile ->
            if (bitmapFile.exists())
                return FormPart(
                    key = "image",
                    value = bitmapFile.readBytes(),
                    headers = Headers.build {
                        append(HttpHeaders.ContentType, "image/*")
                        append(
                            HttpHeaders.ContentDisposition,
                            "filename=\"${bitmapFile.name}\""
                        )
                    }

                )
            else
                throw IllegalStateException("file not found")
        }
    }
}

private class BitmapResolver(
    private val context: Context = getKoin().get()
) : KoinComponent {

    fun resolve(uri: String): ByteArray? {
        context.contentResolver.openInputStream(uri.toUri())
            .use { stream ->
                stream?.readBytes()?.let { bytes ->
                    val outputStream = ByteArrayOutputStream()
                    BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                        .compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
                    return outputStream.toByteArray().also { outputStream.close() }
                }

                return ByteArray(0)
            }
    }
}