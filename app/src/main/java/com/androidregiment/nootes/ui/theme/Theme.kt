package com.androidregiment.nootes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Orange,
    primaryVariant = Orange,
    secondary = Orange,
    surface = Grey200,
    onSurface = Color.White,


    )

private val LightColorPalette = lightColors(
    primary = Orange,
    primaryVariant = Orange,
    secondary = Orange,

//     Other default colors to override
    background = Color.White,
    surface = Orange200,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,

    )

@Composable
fun NootesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}