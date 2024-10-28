package com.sochato.mates.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mates.core.ui.generated.resources.Res
import mates.core.ui.generated.resources.app_name
import mates.core.ui.generated.resources.icon_mates_logo
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun AppLogo(
    modifier: Modifier = Modifier
) {
    val colors = rememberAppLogoColors()

    Image(
        modifier = Modifier
            .size(128.dp)
            .background(
                color = colors.imageBackground,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(all = 24.dp)
            .then(modifier),
        imageVector = vectorResource(Res.drawable.icon_mates_logo),
        contentDescription = "logo"
    )

    VerticalSpacer(height = 16.dp)

    Text(
        text = stringResource(Res.string.app_name),
        style = MaterialTheme.typography.displayLarge,
        color = colors.titleColor
    )
}

@Composable
private fun rememberAppLogoColors(): AppLogoColors {
    val dark = isSystemInDarkTheme()

    return remember(dark) {
        if(dark)
            /*TODO*/
            AppLogoColors(
                imageBackground = Color(0xFF1F1F1F),
                titleColor = Color(0xFF171717)
            )
        else
            AppLogoColors(
                imageBackground = Color(0xFF1F1F1F),
                titleColor = Color(0xFF171717)
            )
    }
}

private data class AppLogoColors(
    val imageBackground: Color,
    val titleColor: Color
)
