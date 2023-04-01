package com.androidregiment.nootes.data.converter

import androidx.room.TypeConverter
import com.androidregiment.nootes.data.entity.Task

class PriorityConverter {

    @TypeConverter
    fun fromPriority(priority: Task.Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Task.Priority {
        return Task.Priority.valueOf(priority)
    }

}
