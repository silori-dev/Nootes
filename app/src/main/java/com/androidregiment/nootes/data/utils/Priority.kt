package com.androidregiment.nootes.data.utils

import androidx.compose.ui.graphics.Color
import androidx.room.TypeConverter
import com.androidregiment.nootes.ui.theme.Blue
import com.androidregiment.nootes.ui.theme.Red
import com.androidregiment.nootes.ui.theme.Teal

enum class Priority(val color: Color) {
    HIGH(color = Red),
    MEDIUM(color = Blue),
    LOW(color = Teal),
}

class PriorityConverter {

    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }

}
