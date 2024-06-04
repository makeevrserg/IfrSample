package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("VOL")
@Serializable
data class VolumeButtonData(
    @SerialName("add")
    val add: IfrKeyData,
    @SerialName("reduce")
    val reduce: IfrKeyData,
) : ButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.VOLUME
}
