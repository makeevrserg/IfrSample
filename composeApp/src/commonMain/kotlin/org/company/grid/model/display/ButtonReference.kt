package org.company.grid.model.display

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface ButtonReference {
    @SerialName("KEY_DATA")
    @Serializable
    class KeyData(val keyDataId: String) : ButtonReference

    @SerialName("BUTTON_AND_KEY_DATA")
    @Serializable
    class ButtonAndKeyData(
        val buttonDataId: String,
        val keyDataId: String
    ) : ButtonReference
}
