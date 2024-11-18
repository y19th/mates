package com.sochato.mates.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import mates.core.ui.generated.resources.Res
import mates.core.ui.generated.resources.icon_default_avatar
import mates.core.ui.generated.resources.icon_default_image
import org.jetbrains.compose.resources.vectorResource

@Composable
fun MatesAvatarImage(
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

@Composable
fun MatesDefaultImage(
    url: String?,
    modifier: Modifier = Modifier,
    loading: @Composable (() -> Unit)? = null,
    placeholderSize: Dp = Dp.Unspecified
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        loading = {
            if (loading != null)
                loading()
            else
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
        },
        error = {
            PlaceholderImage(placeholderSize)
        }
    )
}

@Composable
private fun PlaceholderImage(size: Dp) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .defaultMinSize(minHeight = 128.dp)
            .background(
                color = wrummyColorPalette.outlineColor
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(size),
            imageVector = vectorResource(Res.drawable.icon_default_image),
            contentDescription = null,
            tint = Color(0xFFCCCCCC)
        )
    }
}