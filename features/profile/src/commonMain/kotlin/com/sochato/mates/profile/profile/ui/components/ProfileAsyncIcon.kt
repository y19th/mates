package com.sochato.mates.profile.profile.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import mates.features.profile.generated.resources.Res
import mates.features.profile.generated.resources.icon_default_profile
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun ProfileAsyncIcon(
    url: String?,
    modifier: Modifier = Modifier
) {
    if (url != null)
        SubcomposeAsyncImage(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = CircleShape
                )
                .then(modifier),
            model = url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            loading = {
                CircularProgressIndicator()
            }
        )
    else
        Image(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .then(modifier),
            imageVector = vectorResource(Res.drawable.icon_default_profile),
            contentDescription = null
        )
}