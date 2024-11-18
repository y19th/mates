package com.sochato.mates.profile.profile.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.HorizontalSpacer
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.core.util.extension.shaped
import mates.features.profile.generated.resources.Res
import mates.features.profile.generated.resources.ic_next
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun ProfileButton(
    image: DrawableResource,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shaped(borderColor = MaterialTheme.colorScheme.outlineVariant)
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp),
            imageVector = vectorResource(image),
            contentDescription = null,
            tint = wrummyColorPalette.homePrimaryColor
        )

        HorizontalSpacer(width = 24.dp)

        TextRegular(
            text = title,
            fontSize = 16.sp,
            color = wrummyColorPalette.homePrimaryColor
        )

        Spacer(
            modifier = Modifier
                .weight(0.5f)
        )

        Icon(
            imageVector = vectorResource(Res.drawable.ic_next),
            tint = wrummyColorPalette.homePrimaryColor,
            contentDescription = null
        )
    }
}