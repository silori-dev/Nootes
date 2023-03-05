package com.androidregiment.nootes.tabLayout

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.androidregiment.nootes.screen.notes.allNotes.ui.screen.AllNotesScreen
import com.androidregiment.nootes.screen.tasks.AllTasksScreen


sealed class TabLayoutScreen(
    val activeIcon: ImageVector,
    val inactiveIcon: ImageVector,
    val title: String,
    val content: @Composable (navController: NavController) -> Unit,
) {

    object AllNotes : TabLayoutScreen(
        activeIcon = Icons.Filled.Edit,
        inactiveIcon = Icons.Outlined.Edit,
        title = "Notes",
        content = { AllNotesScreen(navController = (it)) }
    )

    @OptIn(ExperimentalMaterialApi::class)
    data class AllTasks(
        val modalBottomSheetState: ModalBottomSheetState,
    ) : TabLayoutScreen(
        activeIcon = Icons.Filled.CheckCircle,
        inactiveIcon = Icons.Outlined.CheckCircle,
        title = "Tasks",
        content = {
            AllTasksScreen(
                modalBottomSheetState = modalBottomSheetState
            )
        }
    )
}