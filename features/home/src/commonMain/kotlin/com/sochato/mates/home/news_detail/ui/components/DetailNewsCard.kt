package com.sochato.mates.home.news_detail.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.MatesDefaultImage
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.home.main.domain.model.MainNews

@Composable
internal fun DetailNewsCard(
    item: MainNews,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        MatesDefaultImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            url = item.image,
            placeholderSize = 128.dp
        )

        VerticalSpacer(height = 4.dp)

        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
        ) {
            TextSemibold(
                modifier = Modifier
                    .fillMaxWidth(0.9f),
                text = item.title,
                fontSize = 28.sp,
                lineHeight = 28.sp,
                color = wrummyColorPalette.primaryTextColor
            )

            TextRegular(
                text = item.author,
                fontSize = 18.sp,
                color = wrummyColorPalette.secondaryTextColor
            )

            VerticalSpacer(height = 24.dp)

            TextSemibold(
                text = "Описание",
                fontSize = 20.sp,
                lineHeight = 30.sp,
                color = wrummyColorPalette.primaryTextColor
            )

            VerticalSpacer(height = 12.dp)

            TextRegular(
                text = item.content,
                fontSize = 14.sp,
                color = wrummyColorPalette.secondaryTextColor
            )
        }
    }

}