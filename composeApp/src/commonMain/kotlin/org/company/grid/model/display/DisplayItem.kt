package org.company.grid.model.display

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrButton

@Serializable
class DisplayItem(
    @SerialName("key_data_ref_id")
    val keyDataRefId: String,
    @SerialName("position")
    val position: IfrButton.Position,
    @SerialName("size")
    val size: IfrButton.Size = IfrButton.Size(),
    @SerialName("data")
    val data: DisplayData
)
