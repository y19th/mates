package com.sochato.mates.profile.friends.ui.components.all

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.profile.friends.domain.models.Mate
import mates.features.profile.generated.resources.Res
import mates.features.profile.generated.resources.friends_all_header
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun AllMatesSection(
    users: List<Mate>,
    onMateClick: (Mate) -> Unit
) {
    LazyColumn {
        item {
            TextSemibold(
                text = stringResource(Res.string.friends_all_header),
                fontSize = 20.sp,
                color = wrummyColorPalette.primaryTextColor
            )
        }
        item {
            VerticalSpacer(height = 32.dp)
        }
        if (users.isNotEmpty())
            items(
                items = users,
                key = { it.uid }
            ) { user ->
                MateItem(
                    mate = user,
                    onMateClick = { onMateClick(user) }
                )

                VerticalSpacer(height = 16.dp)
            }
        else
            item {
                NoMatesFound()
            }
    }
}