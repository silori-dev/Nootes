package com.androidregiment.nootes.tabLayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.androidregiment.nootes.component.AddFloatingActionButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(
    list: List<TabLayoutScreen>,
) {

    val pagerState = rememberPagerState()

    val activeScreenPosition by derivedStateOf {
        pagerState.currentPage
    }
    TabLayoutContent(
        activeScreenPosition = activeScreenPosition,
        list = list,
        pagerState = pagerState
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayoutContent(
    modifier: Modifier = Modifier,
    list: List<TabLayoutScreen>,
    activeScreenPosition: Int,
    pagerState: PagerState,
) {
    Scaffold(
        floatingActionButton = { AddFloatingActionButton(onClick = {}) }
    ) { paddingValues ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            TabsRow(
                activeScreenPosition = activeScreenPosition,
                list = list,
            )
            TabsScreen(
                list = list,
                pagerState = pagerState,
            )
        }
    }
}