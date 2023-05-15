package com.dmitriy_liubinskiy.taptapcat.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = Yellow900,
    onPrimary = Amber900,
    secondary = Blue500
)

private val LightColorPalette = lightColorScheme(
    primary = Amber900,
    onPrimary = BlueX,
    secondary = Blue500,
    background = Amber50,
    onBackground = Amber900,
    surface = Yellow900,
    onSurface = Amber900
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
