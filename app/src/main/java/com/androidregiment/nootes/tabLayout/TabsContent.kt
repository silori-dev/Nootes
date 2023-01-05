package com.androidregiment.nootes.tabLayout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsScreen(
    modifier: Modifier = Modifier,
    pagerState : PagerState,
    list: List<TabLayoutScreen>,
) {
    HorizontalPager(count = list.size, state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
        list[page].content()
    }
}