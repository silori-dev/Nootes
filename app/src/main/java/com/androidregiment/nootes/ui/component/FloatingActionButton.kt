package com.androidregiment.nootes.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddFloatingActionButton(
    modalBottomSheetState: () -> ModalBottomSheetState,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    AnimatedVisibility(
        visible =
        !modalBottomSheetState().isVisible,
        enter = fadeIn(),
        exit = fadeOut(),

        ) {
        FloatingActionButton(
            modifier = modifier,
            onClick = { onClick() }, elevation = FloatingActionButtonDefaults.elevation()
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }
    }
}
