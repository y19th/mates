package com.sochato.mates.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.buttons.RoundedButton
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import mates.core.ui.generated.resources.Res
import mates.core.ui.generated.resources.error_button
import mates.core.ui.generated.resources.error_header
import mates.core.ui.generated.resources.icon_something_wrong
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun ErrorContent(
    onRefresh: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .size(128.dp),
                imageVector = vectorResource(Res.drawable.icon_something_wrong),
                tint = wrummyColorPalette.primaryColor,
                contentDescription = null
            )

            VerticalSpacer(18.dp)

            TextSemibold(
                text = stringResource(Res.string.error_header),
                fontSize = 36.sp,
                lineHeight = 54.sp,
                textAlign = TextAlign.Center
            )

            VerticalSpacer(height = 24.dp)

            RoundedButton(
                title = stringResource(Res.string.error_button),
                onClick = onRefresh
            )
        }
    }
}