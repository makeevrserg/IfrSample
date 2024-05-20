package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.core.model.ButtonType

@SerialName("CHANNEL")
@Serializable
class ChannelButtonData(
    val add: KeyData,
    val reduce: KeyData,
) : ButtonData {
    override val buttonType: ButtonType = ButtonType.BUTTON_CH
}
