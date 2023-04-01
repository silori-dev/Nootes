package com.androidregiment.nootes.screen.notes.editNote

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.androidregiment.nootes.ui.component.NooteTextField

@Composable
fun EditNoteScreen(
    navController: NavController,
    viewModel: EditNoteViewModel = hiltViewModel(),
) {

    val noteState by viewModel.noteFlow.collectAsState()

    EditNoteContent(
        title = { noteState.title },
        description = { noteState.description },
        onTitleChange = viewModel::onTitleChange,
        onDescriptionChange = viewModel::onDescriptionChange,
        onUpdateNote = viewModel::updateNote,
        navController = navController,
    )
}

@Composable
fun EditNoteContent(
    title: () -> String,
    description: () -> String,
    onTitleChange: (msg: String) -> Unit,
    onDescriptionChange: (msg: String) -> Unit,
    onUpdateNote: () -> Unit,
    navController: NavController,
) {

    Column(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.fillMaxWidth()) {

            IconButton(
                onClick = {
                    onUpdateNote()
                    navController.navigate("all_notes") {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.align(Alignment.CenterStart),
            ) {
                Icon(
                    imageVector = Icons.Default.NavigateBefore,
                    contentDescription = null,
                    modifier = Modifier,
                )
            }

            IconButton(
                onClick = {
                    onUpdateNote()
                },
                modifier = Modifier.align(Alignment.CenterEnd),
            ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = null,
                    modifier = Modifier,
                )
            }
        }

        NooteTextField(
            text = title,
            label = "Title",
            onTextChanged = onTitleChange,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        NooteTextField(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            text = { description() },
            label = "Description",
            onTextChanged = onDescriptionChange,
        )
    }
}
