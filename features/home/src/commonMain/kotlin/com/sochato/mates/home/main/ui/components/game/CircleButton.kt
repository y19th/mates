package com.sochato.mates.home.main.ui.components.game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun CircleButton(
    resource: DrawableResource,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    tint: Color,
    background: Color
) {
    Icon(
        modifier = Modifier
            .size(32.dp)
            .background(
                color = background,
                shape = CircleShape
            )
            .clip(CircleShape)
            .clickable(onClick = onClick)
            .padding(all = 8.dp)
            .then(modifier),
        imageVector = vectorResource(resource),
        tint = tint,
        contentDescription = "circle button"
    )
}