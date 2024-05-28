package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("TEXT_BUTTON")
@Serializable
data class TextButtonData(
    override val key: IfrKeyData,
    val text: String
) : SingleKeyButtonData
