package org.company.panel.ui.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import org.company.panel.model.ContainerInfo

object ArrangementUtil {
    fun ContainerInfo.Arrangement.toVerticalArrangement(spacedBy: Int): Arrangement.Vertical {
        return when (this) {
            ContainerInfo.Arrangement.SPACE_BETWEEN -> Arrangement.SpaceBetween
            ContainerInfo.Arrangement.CENTER -> Arrangement.spacedBy(spacedBy.dp, Alignment.CenterVertically)
        }
    }

    fun ContainerInfo.Arrangement.toHorizontalArrangement(spacedBy: Int): Arrangement.Horizontal {
        return when (this) {
            ContainerInfo.Arrangement.SPACE_BETWEEN -> Arrangement.SpaceBetween
            ContainerInfo.Arrangement.CENTER -> Arrangement.spacedBy(spacedBy.dp, Alignment.CenterHorizontally)
        }
    }

    fun ContainerInfo.VerticalAlignment.toVerticalArrangement(): Alignment.Vertical {
        return when (this) {
            ContainerInfo.VerticalAlignment.CENTER -> Alignment.CenterVertically
        }
    }

    fun ContainerInfo.Alignment.toComposeAlignment(): Alignment {
        return when (this) {
            ContainerInfo.Alignment.TOP_LEFT -> Alignment.TopStart
            ContainerInfo.Alignment.CENTER -> Alignment.Center
            ContainerInfo.Alignment.TOP_CENTER -> Alignment.TopCenter
        }
    }

    fun ContainerInfo.HorizontalAlignment.toComposeAlignment(): Alignment.Horizontal {
        return when (this) {
            ContainerInfo.HorizontalAlignment.START -> Alignment.Start
            ContainerInfo.HorizontalAlignment.CENTER -> Alignment.CenterHorizontally
        }
    }
}
