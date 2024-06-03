package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@Serializable
data class TextButtonData(
    override val keyData: IfrKeyData,
    val text: String
) : SingleKeyButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.TEXT
}
