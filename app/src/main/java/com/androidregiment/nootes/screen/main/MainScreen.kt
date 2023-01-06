package com.androidregiment.nootes.screen.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.androidregiment.nootes.component.AddFloatingActionButton
import com.androidregiment.nootes.navigation.SetupNavGraph
import com.androidregiment.nootes.tabLayout.TabLayoutScreen
import com.androidregiment.nootes.tabLayout.TabLayout
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    SetupNavGraph(navController = navController)


}


