package com.sochato.mates.profile.friends.ui.components.my

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.domain.models.Friend
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import kotlinx.collections.immutable.ImmutableList
import mates.features.profile.generated.resources.Res
import mates.features.profile.generated.resources.friends_my_header
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun MyMatesSection(
    friends: ImmutableList<Friend>
) {
    LazyColumn {
        item {
            TextSemibold(
                text = stringResource(Res.string.friends_my_header),
                fontSize = 20.sp,
                color = wrummyColorPalette.primaryTextColor
            )
        }
        item {
            VerticalSpacer(height = 32.dp)
        }
        if (friends.isNotEmpty())
            items(friends) { friend ->
                FriendItem(friend)

                VerticalSpacer(height = 16.dp)
            }
        else
            item {
                NoFriendsItem()
            }
    }

}