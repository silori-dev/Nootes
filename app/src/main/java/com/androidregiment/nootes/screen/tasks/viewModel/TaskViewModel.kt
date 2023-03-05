package com.androidregiment.nootes.screen.tasks.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.androidregiment.nootes.data.database.NooteDatabase
import com.androidregiment.nootes.data.entity.Note
import com.androidregiment.nootes.data.entity.Task
import com.androidregiment.nootes.data.utils.Priority
import com.androidregiment.nootes.screen.tasks.data.TaskRepoImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    val repo: TaskRepoImpl
    val allTask: Flow<List<Task>>


    init {
        val dao = NooteDatabase.getDatabase(application).taskDao()
        repo = TaskRepoImpl(dao = dao)
        allTask = repo.getAllTasks()
    }

    private val _task =
        MutableStateFlow<Task>(Task(title = "", isComplete = false, priority = Priority.LOW))
    val task: StateFlow<Task> = _task

    fun changeTitle(title: String) {
        _task.value = _task.value.copy(title = title)
    }

    fun changePriority(priority: Priority) {
        _task.value = _task.value.copy(priority = priority)
    }

    fun changeTaskStatus(isComplete: Boolean, id: Int) {
        viewModelScope.launch {
            repo.updateTaskStatus(id = id, isComplete = isComplete)
        }
    }

    fun saveTask() {
        viewModelScope.launch {
            repo.saveTask(_task.value)
        }
        resetTaskValue()
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repo.deleteTask(task)
        }
    }

    private fun resetTaskValue() {
        _task.value = Task(title = "", isComplete = false, priority = Priority.LOW)
    }

    fun updateTask(task: Task) {
        _task.value = task
    }


}