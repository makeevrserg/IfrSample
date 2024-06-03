package org.company.core.ui.button.core

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Reply
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.SettingsPower
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import org.company.grid.model.buttondata.IconButtonData

@Composable
internal fun SquareIconButton(
    onClick: () -> Unit,
    painter: Painter,
    background: Color,
    iconTint: Color,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
) {
    SquareButton(
        modifier = modifier,
        onClick = onClick,
        background = background
    ) {
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            tint = iconTint,
            modifier = Modifier.fillMaxSize().padding(12.dp)
        )
    }
}

@Composable
internal fun SquareImageButton(
    onClick: () -> Unit,
    bitmap: ImageBitmap,
    background: Color,
    iconTint: Color,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
) {
    SquareButton(
        modifier = modifier,
        onClick = onClick,
        background = background
    ) {
        Icon(
            bitmap = bitmap,
            contentDescription = contentDescription,
            tint = iconTint,
            modifier = Modifier.fillMaxSize().padding(12.dp)
        )
    }
}

@Composable
internal fun SquareIconButton(
    iconType: IconButtonData.IconType,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    onClick: () -> Unit,
) {
    SquareButton(
        modifier = modifier,
        onClick = onClick,
        background = Color(0xFF303030)
    ) {
        Icon(
            painter = when (iconType) {
                IconButtonData.IconType.BACK -> rememberVectorPainter(Icons.AutoMirrored.Filled.Reply)
                IconButtonData.IconType.HOME -> rememberVectorPainter(Icons.Outlined.Home)
                IconButtonData.IconType.INFO -> rememberVectorPainter(Icons.Outlined.Info)
                IconButtonData.IconType.MORE -> rememberVectorPainter(Icons.Filled.MoreHoriz)
                IconButtonData.IconType.MUTE -> rememberVectorPainter(Icons.AutoMirrored.Filled.VolumeOff)
                IconButtonData.IconType.POWER -> rememberVectorPainter(Icons.Default.SettingsPower)
            },
            contentDescription = contentDescription,
            tint = when (iconType) {
                IconButtonData.IconType.BACK,
                IconButtonData.IconType.HOME,
                IconButtonData.IconType.INFO,
                IconButtonData.IconType.MORE,
                IconButtonData.IconType.MUTE -> MaterialTheme.colors.onPrimary

                IconButtonData.IconType.POWER -> Color(0xFFF63F3F)
            },
            modifier = Modifier.fillMaxSize().padding(12.dp)
        )
    }
}
