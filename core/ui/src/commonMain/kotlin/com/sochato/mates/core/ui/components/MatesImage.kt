package com.sochato.mates.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.SubcomposeAsyncImage
import mates.core.ui.generated.resources.Res
import mates.core.ui.generated.resources.icon_default_avatar
import org.jetbrains.compose.resources.vectorResource

@Composable
fun MatesImage(
    url: String?,
    modifier: Modifier = Modifier,
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        loading = {
            CircularProgressIndicator()
        },
        error = {
            Image(
                modifier = modifier,
                imageVector = vectorResource(Res.drawable.icon_default_avatar),
                contentDescription = null
            )
        }
    )
}