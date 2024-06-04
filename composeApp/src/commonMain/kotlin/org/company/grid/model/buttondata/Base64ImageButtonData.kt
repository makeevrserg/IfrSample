package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@Serializable
data class Base64ImageButtonData(
    @SerialName("key_data")
    override val keyData: IfrKeyData,
    @SerialName("base64_image")
    val base64Image: String,
) : SingleKeyButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.BASE64_IMAGE
}
