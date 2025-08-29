package com.example.calculadoraimc.ui.theme

import android.os.Build
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = GrayLight,
    onPrimary = Black,
    secondary = GrayMedium,
    onSecondary = GrayLight,
    tertiary = GreenAccent,
    onTertiary = White,
    background = Black,
    onBackground = White,
    surface = GrayDark,
    onSurface = White
)

@Composable
fun CalculadoraIMCTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        else -> DarkColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}