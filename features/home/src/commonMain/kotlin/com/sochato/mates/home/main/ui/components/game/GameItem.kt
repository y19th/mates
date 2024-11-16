package com.sochato.mates.home.main.ui.components.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.home.main.ui.components.ProceedRow
import com.sochato.mates.home.main.ui.components.ProceedRowColors
import mates.features.home.generated.resources.Res
import mates.features.home.generated.resources.default_game_image
import mates.features.home.generated.resources.icon_add
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun GameItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .defaultMinSize(minHeight = 130.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(Res.drawable.default_game_image),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )

        ProceedRow(
            modifier = Modifier
                .padding(horizontal = 18.dp, vertical = 16.dp)
                .align(Alignment.BottomEnd),
            text = "Перейти",
            colors = ProceedRowColors.Default.colors(),
            onClick = {

            }
        )
    }
}

@Composable
internal fun AddGameItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .background(
                color = wrummyColorPalette.outlineColor,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = vectorResource(Res.drawable.icon_add),
                contentDescription = "add car",
                tint = Color(0xFFCCCCCC)
            )
            TextRegular(
                text = "Найти вашу игру",
                fontSize = 16.sp,
                color = wrummyColorPalette.onOutlineColor
            )
        }
    }
}
