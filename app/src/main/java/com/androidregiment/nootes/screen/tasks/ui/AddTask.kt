package com.androidregiment.nootes.screen.tasks.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.androidregiment.nootes.data.entity.Task
import com.androidregiment.nootes.data.utils.Priority
import com.androidregiment.nootes.screen.component.NooteTextField

@Composable
fun AddTask(
    taskState: () -> State<Task>,
    onTextChange: (txt: String) -> Unit,
    onDoneClick: () -> Unit,
    onPriorityChange: (priority: Priority) -> Unit,
) {
    AddTaskContent(
        taskState = { taskState() },
        onTextChange = { onTextChange(it) },
        onDoneClick = {
            onDoneClick()
        },
        onPriorityChange = { onPriorityChange(it) }
    )
}

@Composable
fun AddTaskContent(

    taskState: () -> State<Task>,
    onTextChange: (txt: String) -> Unit,
    onDoneClick: () -> Unit,
    onPriorityChange: (priority: Priority) -> Unit,
) {

    val taskColor = animateColorAsState(targetValue = taskState().value.priority.color)
    Surface(
        shape = RoundedCornerShape(topStartPercent = 25, topEndPercent = 25),
        color = taskColor.value,
        elevation = 20.dp
    ) {
        Surface(
            shape = RoundedCornerShape(topStartPercent = 25),
            modifier = Modifier.padding(start = 8.dp),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                NooteTextField(
                    text = { taskState().value.title },
                    label = "Add Task",
                    onTextChanged = { onTextChange(it) })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    PriorityButton(Priority.LOW,
                        currentPriority = { taskState().value.priority },
                        onChangePriorityClick = { onPriorityChange(it) })

                    PriorityButton(Priority.MEDIUM,
                        currentPriority = { taskState().value.priority },
                        onChangePriorityClick = { onPriorityChange(it) })
                    PriorityButton(Priority.HIGH,
                        currentPriority = { taskState().value.priority },
                        onChangePriorityClick = { onPriorityChange(it) })
                }
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                    Button(onClick = { onDoneClick() }) {
                        Text(text = "Done")
                    }
                }
            }
        }
    }
}