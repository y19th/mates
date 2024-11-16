package com.sochato.mates.home.game_detail.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
internal fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Icon(
        modifier = Modifier
            .offset { IntOffset(0, 64) }
            .padding(horizontal = 8.dp)
            .size(40.dp)
            .clip(CircleShape)
            .background(
                color = Color.Black.copy(alpha = 0.5f)
            )
            .semantics { role = Role.Button }
            .clickable { onClick.invoke() }
            .padding(all = 8.dp)
            .then(modifier),
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        tint = Color.White,
        contentDescription = "BackButton"
    )
}