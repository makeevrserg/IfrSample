package org.company.grid.model.display

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrButton

@Serializable
class DisplayData(
    val refId: String,
    val text: String,
    val position: IfrButton.Position,
)
