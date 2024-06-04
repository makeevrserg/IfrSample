package org.company.grid.model

import kotlinx.serialization.Serializable
import org.company.grid.model.display.DisplayItem

@Serializable
class Display(
    val position: IfrButton.Position,
    val size: IfrButton.Size,
    val items: List<DisplayItem>
)
