package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@SerialName("NAV")
@Serializable
data class NavigationButtonData(
    val up: IfrKeyData,
    val left: IfrKeyData,
    val down: IfrKeyData,
    val right: IfrKeyData,
    val ok: IfrKeyData,
) : ButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.NAVIGATION
}
