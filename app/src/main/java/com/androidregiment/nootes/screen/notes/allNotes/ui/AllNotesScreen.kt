package com.androidregiment.nootes.screen.notes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.screen.notes.allNotes.viewModel.AllNotesViewModel

@Composable
fun AllNotesScreen(
    viewModel: AllNotesViewModel = viewModel()
) {
    val list = viewModel.allNotes.collectAsState(initial = listOf())

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "All Notes", textAlign = TextAlign.Center)
    }
    AllNoetesScreenContent(allNotesList = list)
}

@Composable
fun AllNoetesScreenContent(
    allNotesList: State<List<Note>>
) {
    val listState = rememberLazyListState()
    LazyColumn(state = listState) {
        items(allNotesList.value) {
            notesItem(note = it)
        }
    }

}


@Composable
fun notesItem(note: Note) {

    Column(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    )
    {
        Text(text = note.title)
    }

}