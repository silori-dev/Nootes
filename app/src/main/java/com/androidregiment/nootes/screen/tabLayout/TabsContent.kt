package com.androidregiment.nootes.screen.tabLayout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsScreen(
    pagerState: PagerState,
    list: List<TabLayoutScreen>,
    navController: NavController,
) {
    HorizontalPager(
        count = list.size,
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        list[page].content(navController = navController)
    }
}
