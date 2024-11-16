package com.sochato.mates.home.game_detail.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.domain.models.LibraryItem
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.texts.TextMedium
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import mates.features.home.generated.resources.Res
import mates.features.home.generated.resources.default_game_image
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailGameCard(
    item: LibraryItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            painter = painterResource(Res.drawable.default_game_image),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        VerticalSpacer(height = 4.dp)

        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
        ) {
            TextSemibold(
                text = item.title,
                fontSize = 28.sp,
                color = wrummyColorPalette.primaryTextColor
            )

            TextRegular(
                text = item.publisher,
                fontSize = 18.sp,
                color = wrummyColorPalette.secondaryTextColor
            )

            VerticalSpacer(height = 12.dp)

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                item.genres.forEach { genre ->
                    GenreChip(title = genre)
                }
            }

            VerticalSpacer(height = 12.dp)

            TextSemibold(
                text = "Описание",
                fontSize = 20.sp,
                lineHeight = 30.sp,
                color = wrummyColorPalette.primaryTextColor
            )

            VerticalSpacer(height = 12.dp)

            TextRegular(
                text = item.description,
                fontSize = 14.sp,
                color = wrummyColorPalette.secondaryTextColor
            )

            VerticalSpacer(height = 16.dp)

            Column {
                TextMedium(
                    text = "Поддерживаемые платформы: ",
                    fontSize = 14.sp,
                )

                VerticalSpacer(height = 4.dp)

                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    item.platforms.forEach { platform ->
                        GenreChip(title = platform)
                    }
                }
            }

        }
    }

}