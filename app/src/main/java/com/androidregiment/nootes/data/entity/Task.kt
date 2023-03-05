package com.androidregiment.nootes.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.androidregiment.nootes.data.utils.Priority

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val isComplete: Boolean,
    val priority: Priority
)
