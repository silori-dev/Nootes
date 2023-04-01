package com.androidregiment.nootes.data.repository.impl

import com.androidregiment.nootes.data.dao.TaskDao
import com.androidregiment.nootes.data.entity.Task
import com.androidregiment.nootes.data.repository.TaskRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepoImpl @Inject constructor(private val dao: TaskDao) : TaskRepo {

    override fun getAllTasks(): Flow<List<Task>> = dao.getAllTask()

    override suspend fun saveTask(task: Task) = dao.saveTask(task = task)

    override suspend fun deleteTask(task: Task) = dao.deleteTask(task = task)

    override fun getTaskById(id: Int): Flow<Task?> = dao.getTaskById(id = id)

    override suspend fun updateTaskStatus(id: Int, isComplete: Boolean) =
        dao.updateTaskStatus(id = id, isComplete = isComplete)
}
