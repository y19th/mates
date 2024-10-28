package com.sochato.mates.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.ui.shared.determineTheme
import io.github.alexzhirkevich.cupertino.adaptive.AdaptiveTheme
import io.github.alexzhirkevich.cupertino.adaptive.CupertinoThemeSpec
import io.github.alexzhirkevich.cupertino.adaptive.ExperimentalAdaptiveApi
import io.github.alexzhirkevich.cupertino.adaptive.MaterialThemeSpec
import io.github.alexzhirkevich.cupertino.theme.darkColorScheme as cupertinoDarkColorScheme
import io.github.alexzhirkevich.cupertino.theme.lightColorScheme as cupertinoLightColorScheme

@OptIn(ExperimentalAdaptiveApi::class)
@Composable
fun WrummyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val theme = remember { determineTheme() }

    val colorScheme = if (darkTheme)
        darkColorScheme(
            primary = Primary,
            onPrimary = OnPrimary,
            background = Background,
            onBackground = OnBackground,
            surface = Surface,
            onSurface = OnSurface,
            outline = Border,
            outlineVariant = BorderVariant
        )
    else
        lightColorScheme(
            primary = Primary,
            onPrimary = OnPrimary,
            background = Background,
            onBackground = OnBackground,
            surface = Surface,
            onSurface = OnSurface,
            outline = Border,
            outlineVariant = BorderVariant
        )

    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(12.dp),
        large = RoundedCornerShape(0.dp)
    )

    val typography = WrummyTypography()

    AdaptiveTheme(
        target = theme, material = MaterialThemeSpec.Default(
            colorScheme = colorScheme,
            typography = typography,
            shapes = shapes
        ),
        cupertino = CupertinoThemeSpec.Default(
            colorScheme = if (isSystemInDarkTheme())
                cupertinoDarkColorScheme(
                    systemBackground = Background /*TODO*/
                ) else
                cupertinoLightColorScheme(
                    systemBackground = Background
                )
        ),
        content = content
    )
}