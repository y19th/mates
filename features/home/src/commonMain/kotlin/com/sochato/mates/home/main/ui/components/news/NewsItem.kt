package com.sochato.mates.home.main.ui.components.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.core.util.extension.shaped
import com.sochato.mates.home.main.domain.model.MainNews
import mates.features.home.generated.resources.Res
import mates.features.home.generated.resources.default_news_image
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun NewsItem(
    item: MainNews
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(Res.drawable.default_news_image),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset { IntOffset(x = 0, y = -32) }
                .shaped(
                    shape = RoundedCornerShape(20.dp),
                    borderWidth = 0.5.dp,
                    borderColor = Color(0xFFE0E0E0)
                )
                .padding(horizontal = 8.dp, vertical = 16.dp)
        ) {
            TextSemibold(
                modifier = Modifier
                    .fillMaxWidth(0.8f),
                text = item.title,
                fontSize = 24.sp,
                color = wrummyColorPalette.primaryTextColor,
            )

            VerticalSpacer(height = 12.dp)

            TextRegular(
                text = item.content,
                fontSize = 12.sp,
                color = wrummyColorPalette.secondaryTextColor
            )
        }
    }
}