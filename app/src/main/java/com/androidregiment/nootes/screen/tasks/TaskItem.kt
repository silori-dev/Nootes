package com.androidregiment.nootes.screen.tasks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.androidregiment.nootes.data.entity.Task

@Composable
fun TaskItem(
    task: Task,
    onCheckedClick: (isComplete: Boolean, id: Int) -> Unit,
    onDeleteClick: (task: Task) -> Unit,
    modifier: Modifier = Modifier,
    onTaskItemClick: () -> Unit,

    ) {

    Card(
        modifier = modifier

            .fillMaxWidth()
            .clickable {
                onTaskItemClick()
            },
        backgroundColor = task.priority.color,
        shape = RoundedCornerShape(25)

    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 4.dp), shape = RoundedCornerShape(25)
        ) {

            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Checkbox(checked = task.isComplete, onCheckedChange = { isComplete ->
                    onCheckedClick(isComplete, task.id)
                })

                Text(
                    text = task.title,
                    modifier = Modifier.weight(1f),
                    maxLines = 5,
                )

                IconButton(onClick = { onDeleteClick(task) }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                }
            }
        }
    }

}