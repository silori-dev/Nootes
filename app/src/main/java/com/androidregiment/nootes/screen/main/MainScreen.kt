package com.androidregiment.nootes.screen.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.androidregiment.nootes.ui.navigation.SetupNavGraph

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    SetupNavGraph(navController = navController)

}


