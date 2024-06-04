package org.company.grid.model.display

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrButton

@Serializable
class DisplayData(
    val text: String,
    val position: IfrButton.Position,
)
