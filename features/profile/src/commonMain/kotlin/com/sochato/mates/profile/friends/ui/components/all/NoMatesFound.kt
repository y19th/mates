package com.sochato.mates.profile.friends.ui.components.all

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.texts.TextMedium
import com.sochato.mates.core.ui.theme.wrummyColorPalette

@Composable
internal fun NoMatesFound() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp, horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        TextMedium(
            text = "Никого не найдено",
            fontSize = 16.sp,
            color = wrummyColorPalette.secondaryTextColor
        )
    }

}