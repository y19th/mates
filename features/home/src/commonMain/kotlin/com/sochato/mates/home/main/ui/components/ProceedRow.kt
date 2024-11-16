package com.sochato.mates.home.main.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.HorizontalSpacer
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.home.main.ui.components.game.CircleButton
import mates.features.home.generated.resources.Res
import mates.features.home.generated.resources.icon_arrow_right

@Composable
internal fun ProceedRow(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ProceedColors
) {
    Row(
        modifier = Modifier
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextRegular(
            text = text,
            fontSize = 12.sp,
            color = colors.textColor
        )

        HorizontalSpacer(8.dp)

        CircleButton(
            resource = Res.drawable.icon_arrow_right,
            onClick = onClick,
            background = colors.circleBackgroundColor,
            tint = colors.circleContentColor
        )
    }

}


internal data class ProceedColors(
    val textColor: Color,
    val circleBackgroundColor: Color,
    val circleContentColor: Color
)


internal sealed class ProceedRowColors {

    data object Inverted {

        @Composable
        fun colors(): ProceedColors {
            return ProceedColors(
                textColor = wrummyColorPalette.primaryTextColor,
                circleBackgroundColor = wrummyColorPalette.primaryTextColor,
                circleContentColor = wrummyColorPalette.homeSecondaryTextColor
            )
        }
    }

    data object Default {

        @Composable
        fun colors(): ProceedColors {
            return ProceedColors(
                textColor = wrummyColorPalette.homeSecondaryTextColor,
                circleBackgroundColor = wrummyColorPalette.homeSecondaryTextColor,
                circleContentColor = wrummyColorPalette.primaryTextColor
            )
        }
    }
}