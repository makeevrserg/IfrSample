package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("CHANNEL")
@Serializable
data class ChannelButtonData(
    val add: IfrKeyData,
    val reduce: IfrKeyData,
) : ButtonData {
    override val type: ButtonType = ButtonType.CHANNEL
}
