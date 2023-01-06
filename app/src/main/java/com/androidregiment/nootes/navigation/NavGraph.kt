package com.androidregiment.nootes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.androidregiment.nootes.navigation.screen.NavigationScreen
import com.androidregiment.nootes.screen.addNotes.AddNotes
import com.androidregiment.nootes.tabLayout.TabLayout

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = NavigationScreen.AllNotesScreen.route
    ) {
        composable(
            route = NavigationScreen.AllNotesScreen.route
        ) {
            TabLayout(navController = navController )
        }
        composable(route = NavigationScreen.AddNoteScreen.route) {
            AddNotes(navController = navController)
        }
    }
}