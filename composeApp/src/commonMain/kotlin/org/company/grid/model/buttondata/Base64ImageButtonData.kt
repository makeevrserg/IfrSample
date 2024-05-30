package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("BASE64_IMAGE")
@Serializable
data class Base64ImageButtonData(
    override val keyData: IfrKeyData,
    val base64Image: String,
) : SingleKeyButtonData
