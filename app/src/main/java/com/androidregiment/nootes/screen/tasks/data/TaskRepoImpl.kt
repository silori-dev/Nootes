package com.androidregiment.nootes.screen.tasks.data

import com.androidregiment.nootes.data.dao.task.TaskDao
import com.androidregiment.nootes.data.entity.Task
import com.androidregiment.nootes.data.repo.task.TaskRepo
import kotlinx.coroutines.flow.Flow

class TaskRepoImpl(val dao: TaskDao) : TaskRepo {

    override fun getAllTasks(): Flow<List<Task>> = dao.getAllTask()

    override suspend fun saveTask(task: Task) = dao.saveTask(task = task)

    override suspend fun deleteTask(task: Task) = dao.deleteTask(task = task)

    override fun getTaskById(id: Int): Flow<Task?> = dao.getTaskById(id = id)

    override suspend fun updateTaskStatus(id: Int, isComplete: Boolean) = dao.updateTaskStatus(id = id, isComplete = isComplete)
}