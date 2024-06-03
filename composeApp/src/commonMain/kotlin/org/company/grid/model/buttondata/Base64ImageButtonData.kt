package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@Serializable
data class Base64ImageButtonData(
    override val keyData: IfrKeyData,
    val base64Image: String,
) : SingleKeyButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.BASE64_IMAGE
}
