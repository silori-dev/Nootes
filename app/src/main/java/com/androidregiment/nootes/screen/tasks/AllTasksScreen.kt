package com.androidregiment.nootes.screen.tasks

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidregiment.nootes.data.entity.Task
import com.androidregiment.nootes.data.utils.Priority
import com.androidregiment.nootes.screen.tasks.ui.AddTask
import com.androidregiment.nootes.screen.tasks.viewModel.TaskViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun AllTasksScreen(
    viewModel: TaskViewModel = viewModel(),
    modalBottomSheetState: ModalBottomSheetState,
) {
    val kc = LocalSoftwareKeyboardController.current

    val list = viewModel.allTask.collectAsState(initial = listOf())
    AllTasksContent(
        taskState = { viewModel.task },
        onTextChange = viewModel::changeTitle,
        onDoneClick = {
            viewModel.saveTask()
            kc?.hide()
        },
        onPriorityChange = viewModel::changePriority,
        allTaskState = list,
        onCheckedClick = viewModel::changeTaskStatus,
        onDeleteTask = viewModel::deleteTask,
        modalBottomSheetState = modalBottomSheetState,
        updateTask = {
            viewModel.updateTask(it)
            kc?.show()
        }
    )
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun AllTasksContent(
    allTaskState: State<List<Task>>,
    taskState: () -> StateFlow<Task>,
    onTextChange: (txt: String) -> Unit,
    onDoneClick: () -> Unit,
    onPriorityChange: (priority: Priority) -> Unit,
    onCheckedClick: (isComplete: Boolean, id: Int) -> Unit,
    onDeleteTask: (task: Task) -> Unit,
    modalBottomSheetState: ModalBottomSheetState,
    updateTask: (task: Task) -> Unit,
) {

    val state = taskState().collectAsState()
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetContent = {
            AddTask(
                taskState = { state },
                onTextChange = { onTextChange(it) },
                onDoneClick = {
                    onDoneClick()
                    coroutineScope.launch {
                        modalBottomSheetState.hide()
                    }
                },
                onPriorityChange = { onPriorityChange(it) },
            )
        },
        sheetShape = RoundedCornerShape(topStartPercent = 25, topEndPercent = 25),
        sheetElevation = 25.dp,
        sheetState = modalBottomSheetState,
        modifier = Modifier.fillMaxSize()
    ) {

        if (allTaskState.value.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {

                items(allTaskState.value, key = { it.id }) { task ->

                    TaskItem(
                        task = task,
                        onCheckedClick = { isComplete: Boolean, id: Int ->
                            onCheckedClick(isComplete, id)
                        },
                        onDeleteClick = {
                            onDeleteTask(it)
                        },
                        modifier = Modifier.animateItemPlacement(),
                        onTaskItemClick = {
                            updateTask(task)
                            coroutineScope.launch {
                                modalBottomSheetState.show()
                            }
                        }
                    )
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painterResource(id = com.androidregiment.nootes.R.drawable.add_task),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(0.6f),
                )
                Spacer(modifier = Modifier.heightIn(8.dp))
                Text(text = "No task found")
            }
        }
    }
}


