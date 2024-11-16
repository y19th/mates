package com.sochato.mates.home.main.ui.components.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.core.util.extension.shaped
import com.sochato.mates.home.main.domain.model.MainNews
import com.sochato.mates.home.main.ui.components.ProceedRow
import com.sochato.mates.home.main.ui.components.ProceedRowColors

@Composable
internal fun NewsItem(
    item: MainNews
) {
    val offsetModifier = remember(item) {
        if (item.image != null)
            Modifier.offset { IntOffset(x = 0, y = -48) }
        else
            Modifier
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        SubcomposeAsyncImage(
            model = item.image,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            loading = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(28.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    LinearProgressIndicator()
                }
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .then(offsetModifier)
                .shaped(
                    shape = RoundedCornerShape(20.dp),
                    backgroundColor = wrummyColorPalette.onPrimaryColor,
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

            VerticalSpacer(height = 6.dp)

            TextRegular(
                text = item.author,
                fontSize = 12.sp,
                color = wrummyColorPalette.secondaryTextColor
            )

            VerticalSpacer(height = 8.dp)

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                ProceedRow(
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                    text = "Перейти",
                    colors = ProceedRowColors.Inverted.colors(),
                    onClick = {}
                )
            }
        }
    }
}