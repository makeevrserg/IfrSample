package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.core.model.ButtonType

@Serializable
sealed interface ButtonData {
    @SerialName("button_type")
    val buttonType: ButtonType
}
