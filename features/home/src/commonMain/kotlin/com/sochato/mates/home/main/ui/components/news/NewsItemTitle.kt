package com.sochato.mates.home.main.ui.components.news

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.texts.TextMedium

@Composable
fun NewsItemTitle(sectionTitle: String) {
    TextMedium(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        text = sectionTitle,
        fontSize = 16.sp
    )

    VerticalSpacer(16.dp)
}