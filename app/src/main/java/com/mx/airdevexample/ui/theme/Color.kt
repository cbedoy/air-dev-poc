package com.mx.airdevexample.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

data class AppPalette(
    val brand: Color,
    val accent: Color,
    val support: Color,
    val surface: Color,
    val background: Color
)

private val CoolorsPalette = AppPalette(
    brand = Color(0xFFFE4A49),
    accent = Color(0xFFFED766),
    support = Color(0xFF009FB7),
    surface = Color(0xFFE6E6EA),
    background = Color(0xFFF4F4F8)
)

object AppThemePalette {
    var current: AppPalette by mutableStateOf(CoolorsPalette)
}

fun AppPalette.toLightColorScheme() = lightColorScheme(
    primary = brand,
    onPrimary = Color(0xFF2B0A09),
    primaryContainer = accent,
    onPrimaryContainer = Color(0xFF2F2200),
    secondary = support,
    onSecondary = Color(0xFF001F24),
    secondaryContainer = surface,
    onSecondaryContainer = Color(0xFF002B31),
    tertiary = accent,
    onTertiary = Color(0xFF3A2F00),
    tertiaryContainer = Color(0xFFFFE9A6),
    onTertiaryContainer = Color(0xFF231B00),
    background = background,
    onBackground = Color(0xFF17171A),
    surface = background,
    onSurface = Color(0xFF17171A),
    surfaceVariant = surface,
    onSurfaceVariant = Color(0xFF4E4E57),
    outline = Color(0xFF7A7A84),
    error = Color(0xFFBA1A1A),
    onError = Color.White
)

fun AppPalette.toDarkColorScheme() = darkColorScheme(
    primary = accent,
    onPrimary = Color(0xFF3A2F00),
    primaryContainer = brand,
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF58D5E8),
    onSecondary = Color(0xFF00363D),
    secondaryContainer = support,
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFFFFE08E),
    onTertiary = Color(0xFF3A2F00),
    tertiaryContainer = Color(0xFF5A4900),
    onTertiaryContainer = Color(0xFFFFE08E),
    background = Color(0xFF111316),
    onBackground = Color(0xFFE4E2E6),
    surface = Color(0xFF111316),
    onSurface = Color(0xFFE4E2E6),
    surfaceVariant = Color(0xFF303037),
    onSurfaceVariant = Color(0xFFC9C5D0),
    outline = Color(0xFF928F99),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005)
)
