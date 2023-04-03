package com.androidregiment.nootes.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.androidregiment.nootes.data.entity.Task

@Composable
fun PriorityButton(
    priority: Task.Priority,
    currentPriority: () -> Task.Priority,
    onChangePriorityClick: (priority: Task.Priority) -> Unit,
) {

    val thisColor by animateColorAsState(
        targetValue = if (currentPriority().name == priority.name) priority.color else priority.color.copy(
            alpha = 0.2f
        )
    )

    Button(
        onClick = { onChangePriorityClick(priority) },
        modifier = Modifier
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = thisColor),
        shape = RoundedCornerShape(30)
    ) {
        Text(text = priority.name)
    }

}
