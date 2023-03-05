package com.androidregiment.nootes.data.dao.task

import androidx.room.*
import com.androidregiment.nootes.data.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("Select * FROM task_table WHERE id = :id")
    fun getTaskById(id: Int): Flow<Task>

    @Query("SELECT * FROM task_table")
    fun getAllTask(): Flow<List<Task>>

    @Query("UPDATE task_table SET isComplete = :isComplete WHERE id = :id")
    suspend fun updateTaskStatus (id: Int, isComplete : Boolean)
}