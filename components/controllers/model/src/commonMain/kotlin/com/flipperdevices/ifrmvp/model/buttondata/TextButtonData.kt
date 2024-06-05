package com.flipperdevices.ifrmvp.model.buttondata

import com.flipperdevices.ifrmvp.model.IfrKeyData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TextButtonData(
    @SerialName("key_data")
    override val keyData: IfrKeyData,
    @SerialName("text")
    val text: String
) : SingleKeyButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.TEXT
}
