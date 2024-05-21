package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.KeyData

@SerialName("TEXT_BUTTON")
@Serializable
data class TextButtonData(
    override val key: KeyData,
    val text: String
) : SingleKeyButtonData
