package org.company.core.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

sealed class Material2Theme(
    val colors: Colors,
    val typography: Typography = Typography(),
    val shapes: Shapes = Shapes(),
) {

    data object DefaultDark : Material2Theme(
        colors = darkColors(
            primary = Color(0xFF252B30),
            primaryVariant = Color(0xFF161A1D),
            secondary = Color(0xFFFFC100),
            secondaryVariant = Color(0xFF1B76CA),
            background = Color(0xFF161A1D),
            surface = Color(0xFFFFFFFF),
            error = Color(0xFFCF6679),
            onPrimary = Color(0xFFFFFFFF),
            onSecondary = Color(0xFF697C8A),
            onBackground = Color(0xFFFFFFFF),
            onSurface = Color(0xFF000000),
            onError = Color(0xFFFFFFFF)
        ),
    )

    data object DefaultLight : Material2Theme(
        colors = lightColors(
            primary = Color(0xFFFFFFFF),
            primaryVariant = Color(0xFFF1F1F1),
            secondary = Color(0xFFFFC100),
            secondaryVariant = Color(0xFF106BBB),
            background = Color(0xFFF1F1F1),
            surface = Color(0xFFFFFFFF),
            error = Color(0xFFCF6679),
            onPrimary = Color(0xFF181818),
            onSecondary = Color(0xFF4E5C66),
            onBackground = Color(0xFF181818),
            onSurface = Color(0xFF000000),
            onError = Color(0xFF181818)
        ),
    )
}
