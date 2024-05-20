package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.core.model.ButtonType

@SerialName("NAV")
@Serializable
class NavigationButtonData(
    val up: KeyData,
    val left: KeyData,
    val down: KeyData,
    val right: KeyData,
    val ok: KeyData,
) : ButtonData {
    override val buttonType: ButtonType = ButtonType.NAV
}
