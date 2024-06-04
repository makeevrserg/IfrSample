package org.company.grid.model.buttondata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@Serializable
data class NavigationButtonData(
    @SerialName("up")
    val up: IfrKeyData,
    @SerialName("left")
    val left: IfrKeyData,
    @SerialName("down")
    val down: IfrKeyData,
    @SerialName("right")
    val right: IfrKeyData,
    @SerialName("ok")
    val ok: IfrKeyData,
) : ButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.NAVIGATION
}
