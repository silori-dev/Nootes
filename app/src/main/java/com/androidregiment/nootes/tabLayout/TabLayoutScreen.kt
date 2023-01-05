package com.androidregiment.nootes.tabLayout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.androidregiment.nootes.screen.AllNotesScreen
import com.androidregiment.nootes.screen.AllTasksScreen



sealed class TabLayoutScreen(
    val activeIcon: ImageVector,
    val inactiveIcon: ImageVector,
    val title: String,
    val content: @Composable () -> Unit,
) { 

    object AllNotes : TabLayoutScreen(
        activeIcon = Icons.Filled.Edit,
        inactiveIcon = Icons.Outlined.Edit,
        title = "Notes",
        content = { AllNotesScreen() }
    )

    object AllTasks : TabLayoutScreen(
        activeIcon = Icons.Filled.CheckCircle,
        inactiveIcon = Icons.Outlined.CheckCircle,
        title = "Tasks",
        content = { AllTasksScreen() }
    )
}