package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@Serializable
data class TextButtonData(
    @SerialName("key_data")
    override val keyData: IfrKeyData,
    @SerialName("text")
    val text: String
) : SingleKeyButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.TEXT
}
