package com.androidregiment.nootes.screen.notes.allNotes.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.androidregiment.nootes.R
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.navigation.screen.NavigationScreen
import com.androidregiment.nootes.screen.notes.allNotes.ui.component.NoteItem
import com.androidregiment.nootes.screen.notes.allNotes.viewModel.AllNotesViewModel


@Composable
fun AllNotesScreen(
    viewModel: AllNotesViewModel = hiltViewModel(),
    navController: NavController,

    ) {
    val list = viewModel.allNotes.collectAsState(initial = listOf())

    AllNotesScreenContent(allNotesList = list,
        deleteNote = viewModel::deleteNote,
        onItemClick = { noteId ->
            navController.navigate("${NavigationScreen.EditNoteScreen.route}/$noteId") {
                popUpTo(navController.graph.findStartDestination().id)
            }
        })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AllNotesScreenContent(
    allNotesList: State<List<Note>>,
    deleteNote: (note: Note) -> Unit,
    onItemClick: (noteId: Int) -> Unit
) {
    if (allNotesList.value.isNotEmpty()) {


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 4.dp, end = 4.dp, bottom = 60.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start,


            ) {

            items(allNotesList.value) { note ->
                NoteItem(
                    note = note,
                    onItemClick = {
                        onItemClick(note.id)
                    },
                    onDeleteItemClick = { deleteNote(it) },
                    modifier = Modifier.animateItemPlacement()
                )
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painterResource(id = R.drawable.add_notes),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.6f),
            )
            Spacer(modifier = Modifier.heightIn(8.dp))
            Text(text = "No notes found")

        }
    }
}
