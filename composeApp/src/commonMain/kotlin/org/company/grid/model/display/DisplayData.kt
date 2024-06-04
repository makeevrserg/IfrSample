package org.company.grid.model.display

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.company.grid.model.buttondata.IconButtonData
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Serializable
sealed interface DisplayData {

    @Serializable
    @SerialName("TEXT_ONLY")
    data class TextOnly(val text: String) : DisplayData

    @Serializable
    @SerialName("ICON_ONLY")
    data class IconOnly(val iconType: IconButtonData.IconType) : DisplayData

    @Serializable
    @SerialName("TEMPERATURE")
    data class Temperature(val temperature: Int) : DisplayData

    @Serializable
    @SerialName("FAN_POWER")
    data class FanPower(val fanPower: Int) : DisplayData

    @Serializable
    @SerialName("TIMER")
    data class Timer(val seconds: Long) : DisplayData {
        val duration: Duration = seconds.seconds
    }
}
