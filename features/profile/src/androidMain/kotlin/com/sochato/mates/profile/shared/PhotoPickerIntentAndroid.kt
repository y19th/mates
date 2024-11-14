package com.sochato.mates.profile.shared

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
actual fun PickPhoto(onResult: (String) -> Unit) {
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            onResult(uri?.toString() ?: "")
        }

    LaunchedEffect(Unit) {
        launcher.launch("image/*")
    }
}