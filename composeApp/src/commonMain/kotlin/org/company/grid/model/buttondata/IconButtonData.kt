package org.company.grid.model.buttondata

import kotlinx.serialization.Serializable
import org.company.grid.model.IfrKeyData

@Serializable
data class IconButtonData(
    override val keyData: IfrKeyData,
    val iconType: IconType
) : SingleKeyButtonData {
    override val type: ButtonData.ButtonType = ButtonData.ButtonType.ICON

    enum class IconType {
        BACK, HOME, INFO, MORE, MUTE, POWER,
        COOL, HEAT, FAN
    }
}
