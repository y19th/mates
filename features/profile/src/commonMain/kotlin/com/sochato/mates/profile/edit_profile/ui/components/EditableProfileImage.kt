package com.sochato.mates.profile.edit_profile.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import mates.features.profile.generated.resources.Res
import mates.features.profile.generated.resources.icon_default_profile
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun EditableProfileImage(
    url: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        if (url != null)
            SubcomposeAsyncImage(
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onClick),
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
                    .clickable(onClick = onClick),
                imageVector = vectorResource(Res.drawable.icon_default_profile),
                contentDescription = null
            )

        Icon(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.BottomEnd)
                .offset { IntOffset(-8, 0) }
                .clip(CircleShape)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.background,
                    shape = CircleShape
                )
                .padding(all = 4.dp),
            imageVector = Icons.Default.Edit,
            tint = MaterialTheme.colorScheme.onPrimary,
            contentDescription = null
        )
    }
}