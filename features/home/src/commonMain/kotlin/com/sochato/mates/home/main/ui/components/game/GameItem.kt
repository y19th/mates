package com.sochato.mates.home.main.ui.components.game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.home.main.ui.components.ProceedRow
import com.sochato.mates.home.main.ui.components.ProceedRowColors
import mates.features.home.generated.resources.Res
import mates.features.home.generated.resources.icon_add
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun GameItem(
    title: String,
    image: String?,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(138.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(138.dp),
            model = image,
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.5f),
                            Color.Black.copy(alpha = 0.2f),
                            Color.Transparent
                        )
                    )
                )
                .padding(horizontal = 18.dp, vertical = 16.dp)
                .align(Alignment.TopStart),
            contentAlignment = Alignment.CenterStart
        ) {
            TextSemibold(
                text = title,
                fontSize = 24.sp,
                letterSpacing = 0.3.sp,
                color = wrummyColorPalette.homeSecondaryTextColor
            )
        }

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
