package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.display.DisplayItem

@Serializable
class Display(
    @SerialName("position")
    val position: IfrButton.Position,
    @SerialName("size")
    val size: IfrButton.Size,
    @SerialName("items")
    val items: List<DisplayItem>
)
