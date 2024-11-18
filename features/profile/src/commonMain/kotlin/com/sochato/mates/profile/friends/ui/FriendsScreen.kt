package com.sochato.mates.profile.friends.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sochato.mates.core.ui.components.VerticalSpacer
import com.sochato.mates.core.ui.components.WrummyColumn
import com.sochato.mates.core.ui.components.bars.BackNavigationIcon
import com.sochato.mates.core.ui.components.bars.NavigationTopBar
import com.sochato.mates.core.ui.components.inputs.SearchTextField
import com.sochato.mates.core.util.base_components.rememberHandleEvents
import com.sochato.mates.core.util.extension.collectAsImmediateState
import com.sochato.mates.profile.friends.domain.events.FriendsEvents
import com.sochato.mates.profile.friends.ui.components.all.AllMatesSection
import com.sochato.mates.profile.friends.ui.components.my.MyMatesSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FriendsScreen(
    component: FriendsComponent
) {
    val state by component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    WrummyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 12.dp),
        topBar = {
            NavigationTopBar(
                title = "Mates",
                navigationIcon = {
                    BackNavigationIcon { handleEvents(FriendsEvents.OnNavigateBack) }
                }
            )
        }
    ) {
        SearchTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.search,
            placeholder = "poikst",
            onValueChange = {
                handleEvents(FriendsEvents.OnSearchChanged(it))
            }
        )
        VerticalSpacer(height = 32.dp)

        if (state.search.isEmpty())
            MyMatesSection(
                friends = state.friendsList
            )
        else
            AllMatesSection(
                users = state.filteredUsers
            )
    }
}