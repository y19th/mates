package com.sochato.mates.profile.shared

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.core.content.FileProvider
import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent.getKoin
import java.io.File
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Composable
actual fun TakePhoto(onResult: (String) -> Unit) {
    val externalUri = ContextProvider.receive().createTempPictureUri()
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success)
                onResult(externalUri.toString())
        }

    LaunchedEffect(Unit) {
        launcher.launch(externalUri)
    }
}

private class ContextProvider : KoinComponent {

    companion object {
        fun receive(): Context {
            return getKoin().get<Context>()
        }
    }
}

@OptIn(ExperimentalUuidApi::class)
fun Context.createTempPictureUri(
    provider: String = "MatesFileProvider",
    fileName: String = "picture_${Uuid.random()}",
    fileExtension: String = ".png"
): Uri {
    val tempFile = File.createTempFile(
        fileName, fileExtension, getExternalFilesDir("shared")
    ).apply {
        createNewFile()
    }

    return FileProvider.getUriForFile(applicationContext, provider, tempFile)
}