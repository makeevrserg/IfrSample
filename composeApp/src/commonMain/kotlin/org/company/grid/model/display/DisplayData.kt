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
    data class TextOnly(
        @SerialName("text")
        val text: String
    ) : DisplayData

    @Serializable
    @SerialName("ICON_ONLY")
    data class IconOnly(
        @SerialName("icon_type")
        val iconType: IconButtonData.IconType
    ) : DisplayData

    @Serializable
    @SerialName("TEMPERATURE")
    data class Temperature(
        @SerialName("temperature")
        val temperature: Int
    ) : DisplayData

    @Serializable
    @SerialName("FAN_POWER")
    data class FanPower(
        @SerialName("fan_power")
        val fanPower: Int
    ) : DisplayData

    @Serializable
    @SerialName("TIMER")
    data class Timer(
        @SerialName("seconds")
        val seconds: Long
    ) : DisplayData {
        val duration: Duration = seconds.seconds
    }
}
