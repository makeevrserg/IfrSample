package org.company.panel.ui.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import org.company.panel.model.ContainerInfo

object ArrangementUtil {
    fun ContainerInfo.Arrangement.toComposeArrangement(): Arrangement.HorizontalOrVertical {
        return when (this) {
            ContainerInfo.Arrangement.SPACE_BETWEEN -> Arrangement.SpaceBetween
        }
    }

    fun ContainerInfo.Alignment.toComposeAlignment(): Alignment {
        return when (this) {
            ContainerInfo.Alignment.TOP_LEFT -> Alignment.TopStart
            ContainerInfo.Alignment.CENTER -> Alignment.Center
        }
    }

    fun ContainerInfo.HorizontalAlignment.toComposeAlignment(): Alignment.Horizontal {
        return when (this) {
            ContainerInfo.HorizontalAlignment.START -> Alignment.Start
            ContainerInfo.HorizontalAlignment.CENTER -> Alignment.CenterHorizontally
        }
    }

}