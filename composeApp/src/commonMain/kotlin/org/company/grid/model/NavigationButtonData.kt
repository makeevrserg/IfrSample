package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.core.model.ButtonType

@SerialName("NAV")
@Serializable
class NavigationButtonData(
    val up: String,
    val left: String,
    val down: String,
    val right: String,
    val ok: String,
) : ButtonData {
    override val buttonType: ButtonType = ButtonType.NAV
}
