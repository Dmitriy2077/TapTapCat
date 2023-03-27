package com.dmitriy_liubinskiy.taptapcat.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = Yellow900,
    onPrimary = Red900,
    secondary = Blue500
)

private val LightColorPalette = lightColorScheme(
    primary = Orange800,
    onPrimary = Red900,
    secondary = Blue500
)

@Composable
fun TapTapCatTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}