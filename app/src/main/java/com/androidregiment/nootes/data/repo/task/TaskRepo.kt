package com.androidregiment.nootes.data.repo.task

import com.androidregiment.nootes.data.entity.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepo {

    fun getAllTasks(): Flow<List<Task>>

    suspend fun saveTask(task: Task)

    suspend fun deleteTask(task: Task)

    fun getTaskById(id: Int): Flow<Task?>

    suspend fun updateTaskStatus(id: Int, isComplete: Boolean)
}