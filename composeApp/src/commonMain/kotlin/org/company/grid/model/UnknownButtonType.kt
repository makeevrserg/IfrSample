package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.core.model.ButtonType

@SerialName("UNKNOWN")
@Serializable
data object UnknownButtonType : ButtonData {
    override val buttonType: ButtonType
        get() = ButtonType.UNKNOWN
}
