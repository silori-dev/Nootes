package com.androidregiment.nootes.screen.tasks


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidregiment.nootes.data.entity.Task
import com.androidregiment.nootes.data.repository.TaskRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepo,
) : ViewModel() {

    val allTask: Flow<List<Task>> = taskRepository.getAllTasks()


    private val _task =
        MutableStateFlow(Task(title = "", isComplete = false, priority = Task.Priority.LOW))
    val task: StateFlow<Task> = _task

    fun changeTitle(title: String) {
        _task.value = _task.value.copy(title = title)
    }

    fun changePriority(priority: Task.Priority) {
        _task.value = _task.value.copy(priority = priority)
    }

    fun changeTaskStatus(isComplete: Boolean, id: Int) {
        viewModelScope.launch {
            taskRepository.updateTaskStatus(id = id, isComplete = isComplete)
        }
    }

    fun saveTask() {
        viewModelScope.launch {
            taskRepository.saveTask(_task.value)
        }
        resetTaskValue()
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskRepository.deleteTask(task)
        }
    }

    private fun resetTaskValue() {
        _task.value = Task(title = "", isComplete = false, priority = Task.Priority.LOW)
    }

    fun updateTask(task: Task) {
        _task.value = task
    }


}
