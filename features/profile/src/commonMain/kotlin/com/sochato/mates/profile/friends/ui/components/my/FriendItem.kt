package com.sochato.mates.profile.friends.ui.components.my

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.domain.models.FriendshipStatus
import com.sochato.mates.core.ui.components.HorizontalSpacer
import com.sochato.mates.core.ui.components.MatesAvatarImage
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.theme.wrummyColorPalette
import com.sochato.mates.core.util.extension.noIndicationClickable
import com.sochato.mates.core.util.extension.shaped
import com.sochato.mates.profile.friends.domain.models.InternalMate

@Composable
internal fun FriendItem(
    friend: InternalMate,
    onClick: () -> Unit,
    onFriendshipAccept: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shaped(
                borderColor = MaterialTheme.colorScheme.outlineVariant,
                borderWidth = 0.5.dp
            )
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MatesAvatarImage(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            url = friend.profilePicture
        )

        HorizontalSpacer(width = 8.dp)

        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
        ) {
            TextSemibold(
                text = friend.nickname,
                fontSize = 16.sp,
                color = wrummyColorPalette.primaryTextColor
            )

            VerticalSpacer(height = 4.dp)

            when (friend.status) {
                FriendshipStatus.Blocked -> {
                    TextRegular(
                        text = "запрос на дружбу отклонен",
                        fontSize = 13.sp,
                        color = Color(0xFF7B7B7B)
                    )
                }

                FriendshipStatus.Pending -> {
                    if (friend.isRequested)
                        TextRegular(
                            text = "запрос на дружбу отправлен",
                            fontSize = 13.sp,
                            color = Color(0xFF7B7B7B)
                        )
                    else
                        TextRegular(
                            text = "отправил вам запрос на дружбу",
                            fontSize = 13.sp,
                            lineHeight = 16.sp,
                            color = Color(0xFF7B7B7B)
                        )
                }

                else -> {
                    TextRegular(
                        text = "был в сети недавно",
                        fontSize = 13.sp,
                        color = Color(0xFF7B7B7B)
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        if (!friend.isRequested && friend.status is FriendshipStatus.Pending)
            Icon(
                modifier = Modifier
                    .noIndicationClickable(onClick = onFriendshipAccept),
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
    }
}