package org.company.grid.model.display

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrButton

@Serializable
class DisplayItem(
    val keyDataRefId: String,
    val position: IfrButton.Position,
    val size: IfrButton.Size = IfrButton.Size(),
    val data: DisplayData
)
