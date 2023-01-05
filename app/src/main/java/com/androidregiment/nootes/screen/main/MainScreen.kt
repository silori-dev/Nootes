package com.androidregiment.nootes.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.androidregiment.nootes.tabLayout.TabLayoutScreen
import com.androidregiment.nootes.tabLayout.TabLayout
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen() {
    Scaffold(
        floatingActionButton = {}
    ) { it ->
        val list = listOf(TabLayoutScreen.AllNotes, TabLayoutScreen.AllTasks)

        TabLayout(list = list)

    }
}


