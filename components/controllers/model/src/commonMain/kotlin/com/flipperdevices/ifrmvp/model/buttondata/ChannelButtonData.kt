package com.flipperdevices.ifrmvp.model.buttondata

import com.flipperdevices.ifrmvp.model.IfrKeyData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("CHANNEL")
@Serializable
data class ChannelButtonData(
    @SerialName("add")
    val add: IfrKeyData,
    @SerialName("reduce")
    val reduce: IfrKeyData,
) : ButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.CHANNEL
}
