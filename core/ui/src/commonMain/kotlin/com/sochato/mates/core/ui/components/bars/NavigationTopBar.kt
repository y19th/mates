package com.sochato.mates.core.ui.components.bars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sochato.mates.core.ui.components.texts.TextRegular
import com.sochato.mates.core.ui.components.texts.TextSemibold
import com.sochato.mates.core.ui.extension.shim
import com.sochato.mates.core.ui.theme.TopBarColor
import com.sochato.mates.core.ui.theme.wrummyColorPalette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    colors: TopAppBarColors = TopAppBarDefaults.defaultColor(),
    navigationIcon: @Composable () -> Unit = {},
    trailingIcon: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = { TextSemibold(text = title, fontSize = 20.sp) },
        colors = colors,
        navigationIcon = navigationIcon,
        actions = trailingIcon,
        scrollBehavior = scrollBehavior
    )
}


@Composable
fun WrummyTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    contentText: String = "",
    trailingIcon: @Composable () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Top))
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.65f)
        ) {
            TextRegular(
                text = title,
                color = wrummyColorPalette.homePrimaryColor,
                fontSize = 12.sp,
                maxLines = 1
            )
            TextSemibold(
                text = contentText,
                color = wrummyColorPalette.homePrimaryColor,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        trailingIcon()
    }
}

@Composable
fun ShimmedWrummyTopBar(
    modifier: Modifier = Modifier,
    trailingIcon: @Composable () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Top))
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .height(IntrinsicSize.Max)
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.65f)
                .shim()
        )

        trailingIcon()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarDefaults.defaultColor() = topAppBarColors(
    containerColor = Color.Transparent,
    scrolledContainerColor = Color.Transparent,
    navigationIconContentColor = TopBarColor,
    titleContentColor = TopBarColor,
    actionIconContentColor = TopBarColor
)