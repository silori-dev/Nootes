package com.androidregiment.nootes.screen.notes.addNote.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

@Composable
fun AddNoteScreen(
    navController: NavController,
) {
    IconButton(onClick = {
        navController.navigate("all_notes") {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true        }
    }) {
        Icon(
            imageVector = Icons.Default.NavigateBefore,
            contentDescription = null,
            modifier = Modifier
        )
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Text(text = "Add Notes", textAlign = TextAlign.Center)
    }


}