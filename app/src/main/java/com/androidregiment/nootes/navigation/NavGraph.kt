package com.androidregiment.nootes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.androidregiment.nootes.navigation.screen.NavigationScreen
import com.androidregiment.nootes.screen.notes.addNote.ui.screen.AddNoteScreen
import com.androidregiment.nootes.screen.notes.editNote.ui.EditNoteScreen
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
            TabLayout(navController = navController)
        }
        composable(route = NavigationScreen.AddNoteScreen.route) {
            AddNoteScreen(navController = navController)
        }
        composable(
            route = "${NavigationScreen.EditNoteScreen.route}/{noteId}",
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) {
                EditNoteScreen(
                    navController = navController,
                )
        }
    }
}