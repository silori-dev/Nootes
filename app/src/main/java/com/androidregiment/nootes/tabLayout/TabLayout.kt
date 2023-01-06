package com.androidregiment.nootes.tabLayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.androidregiment.nootes.component.AddFloatingActionButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(
    navController: NavController,
//    list: List<TabLayoutScreen>,
) {
    val list = listOf(TabLayoutScreen.AllNotes, TabLayoutScreen.AllTasks)

    val pagerState = rememberPagerState()

    val activeScreenPosition by derivedStateOf {
        pagerState.currentPage
    }
    TabLayoutContent(
        activeScreenPosition = activeScreenPosition,
        list = list,
        pagerState = pagerState,
        navController = navController,
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayoutContent(
    modifier: Modifier = Modifier,
    list: List<TabLayoutScreen>,
    activeScreenPosition: Int,
    pagerState: PagerState,
    navController: NavController
) {
    Scaffold(
        floatingActionButton = {
            AddFloatingActionButton(onClick = {
                if (pagerState.currentPage == 0) {
                    navController.navigate("add_notes")
                }
            })
        }
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