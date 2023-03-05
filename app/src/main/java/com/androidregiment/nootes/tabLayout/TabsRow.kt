package com.androidregiment.nootes.tabLayout

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TabsRow(
    modifier: Modifier = Modifier,
    activeScreenPosition: Int,
    list: List<TabLayoutScreen>,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(
            24.dp,
            alignment = Alignment.CenterHorizontally
        )
    ) {

        list.forEachIndexed { index, tabLayoutScreen ->
            Tab(
                activeScreenPosition = activeScreenPosition,
                currentPage = index,
                screen = tabLayoutScreen,
            )
        }
    }
}


@Composable
fun Tab(
    activeScreenPosition: Int,
    currentPage: Int,
    screen: TabLayoutScreen,
    ) {
    val isActive by derivedStateOf {
        currentPage == activeScreenPosition
    }

    val iconColor by animateColorAsState(targetValue = if (isActive) MaterialTheme.colors.primary else Color.Gray)

    Icon(
        imageVector =
        if (isActive) screen.activeIcon
        else screen.inactiveIcon,
        contentDescription = screen.title,
        tint = iconColor,
        modifier = Modifier.size(32.dp)

    )
}