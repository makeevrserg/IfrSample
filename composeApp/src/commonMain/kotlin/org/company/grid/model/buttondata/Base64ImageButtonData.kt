package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("BASE64_IMAGE")
@Serializable
data class Base64ImageButtonData(
    override val key: KeyData,
    val base64Image: String,
) : SingleKeyButtonData
