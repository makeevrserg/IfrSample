package com.flipperdevices.ifrmvp.model.buttondata

import com.flipperdevices.ifrmvp.model.IfrKeyData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
