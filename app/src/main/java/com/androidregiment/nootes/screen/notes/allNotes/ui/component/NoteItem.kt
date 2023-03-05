package com.androidregiment.nootes.screen.notes.allNotes.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidregiment.nootes.data.entity.Note

@Composable
fun NoteItem(
    note: Note,
    onItemClick: () -> Unit,
    onDeleteItemClick: (note: Note) -> Unit, modifier: Modifier = Modifier
) {

    Card(
        shape = RoundedCornerShape(size = 20.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                onItemClick()
            },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = note.title,
                    maxLines = 3,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = note.description, modifier = Modifier, maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
            }

            IconButton(onClick = { onDeleteItemClick(note) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}


