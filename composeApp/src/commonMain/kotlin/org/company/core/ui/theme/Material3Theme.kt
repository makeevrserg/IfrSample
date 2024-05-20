package org.company.core.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

sealed class Material3Theme(
    val colorScheme: ColorScheme,
    val typography: Typography = Typography(),
    val shapes: Shapes = Shapes(),
) {

    data object DefaultDark : Material3Theme(
        colorScheme = darkColorScheme(
            primary = Color(0xFF252B30),
            onPrimary = Color(0xFFFFFFFF),
            primaryContainer = Color(0xFF161A1D),
//            onPrimaryContainer = TODO(),
//            inversePrimary = TODO(),
            secondary = Color(0xFFFFC100),
            onSecondary = Color(0xFF697C8A),
            secondaryContainer = Color(0xFF1B76CA),
//            onSecondaryContainer = TODO(),
//            tertiary = TODO(),
//            onTertiary = TODO(),
//            tertiaryContainer = TODO(),
//            onTertiaryContainer = TODO(),
            background = Color(0xFF161A1D),
//            onBackground = TODO(),
            surface = Color(0xFFFFFFFF),
            onSurface = Color(0xFF000000),
//            surfaceVariant = TODO(),
//            onSurfaceVariant = TODO(),
//            surfaceTint = TODO(),
//            inverseSurface = TODO(),
//            inverseOnSurface = TODO(),
//            onError = TODO(),
//            errorContainer = TODO(),
//            onErrorContainer = TODO(),
//            outline = TODO(),
//            outlineVariant = TODO(),
//            scrim = TODO(),
//            surfaceBright = TODO(),
//            surfaceContainer = TODO(),
//            surfaceContainerHigh = TODO(),
//            surfaceContainerHighest = TODO(),
//            surfaceContainerLow = TODO(),
//            surfaceContainerLowest = TODO(),
//            surfaceDim = TODO(),
        ),
    )

    data object DefaultLight : Material3Theme(
        colorScheme = lightColorScheme(
            primary = Color(0xFFFFFFFF),
            onPrimary = Color(0xFF181818),
            primaryContainer = Color(0xFFF1F1F1),
//            onPrimaryContainer = TODO(),
//            inversePrimary = TODO(),
            secondary = Color(0xFFFFC100),
            onSecondary = Color(0xFF4E5C66),
            secondaryContainer = Color(0xFF106BBB),
//            onSecondaryContainer = TODO(),
//            tertiary = TODO(),
//            onTertiary = TODO(),
//            tertiaryContainer = TODO(),
//            onTertiaryContainer = TODO(),
            background = Color(0xFFF1F1F1),
//            onBackground = TODO(),
            surface = Color(0xFFFFFFFF),
            onSurface = Color(0xFF000000),
//            surfaceVariant = TODO(),
//            onSurfaceVariant = TODO(),
//            surfaceTint = TODO(),
//            inverseSurface = TODO(),
//            inverseOnSurface = TODO(),
//            onError = TODO(),
//            errorContainer = TODO(),
//            onErrorContainer = TODO(),
//            outline = TODO(),
//            outlineVariant = TODO(),
//            scrim = TODO(),
//            surfaceBright = TODO(),
//            surfaceContainer = TODO(),
//            surfaceContainerHigh = TODO(),
//            surfaceContainerHighest = TODO(),
//            surfaceContainerLow = TODO(),
//            surfaceContainerLowest = TODO(),
//            surfaceDim = TODO(),
        ),
    )
}
