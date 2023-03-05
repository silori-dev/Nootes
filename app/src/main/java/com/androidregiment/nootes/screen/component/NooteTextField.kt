package com.androidregiment.nootes.screen.component

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.androidregiment.nootes.ui.theme.Transparent

@Composable
fun NooteTextField(
    text: () -> String,
    label: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier,
        value = text(),
        onValueChange = {
            onTextChanged(it)
        },
        label = {
            Text(label)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Transparent,
            focusedIndicatorColor = Transparent,
            unfocusedIndicatorColor = Transparent
        )
    )
}