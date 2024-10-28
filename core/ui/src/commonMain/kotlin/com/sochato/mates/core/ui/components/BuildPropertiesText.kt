package com.sochato.mates.core.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.core.util.local.WrummySettings
import com.sochato.mates.core.util.models.versionName

@Composable
fun BuildPropertiesText(
    modifier: Modifier = Modifier,
    color: Color = wrummyColorPalette.tertiaryTextColor,
    style: TextStyle = MaterialTheme.typography.displaySmall
) {
    val versionName = rememberSaveable {
        WrummySettings.properties.versionName()
    }

    Text(
        modifier = modifier,
        text = versionName,
        style = style,
        color = color
    )

}