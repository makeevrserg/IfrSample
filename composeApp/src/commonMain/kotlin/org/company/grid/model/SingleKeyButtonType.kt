package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.core.model.ButtonType

@SerialName("SINGLE_KEY")
@Serializable
class SingleKeyButtonType(
    val key: String,
    override val buttonType: ButtonType
) : ButtonData
