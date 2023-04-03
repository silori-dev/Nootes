package com.androidregiment.nootes.data.entity

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.androidregiment.nootes.ui.theme.Blue
import com.androidregiment.nootes.ui.theme.Red
import com.androidregiment.nootes.ui.theme.Teal

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val isComplete: Boolean,
    val priority: Priority
) {
    enum class Priority(val color: Color) {
        HIGH(color = Red),
        MEDIUM(color = Blue),
        LOW(color = Teal),
    }
}
