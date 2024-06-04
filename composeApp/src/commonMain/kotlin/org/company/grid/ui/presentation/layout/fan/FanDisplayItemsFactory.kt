package org.company.grid.ui.presentation.layout.fan

import org.company.grid.model.IfrButton
import org.company.grid.model.buttondata.IconButtonData
import org.company.grid.model.display.DisplayData
import org.company.grid.model.display.DisplayItem
import kotlin.time.Duration.Companion.hours

object FanDisplayItemsFactory {
    fun create() = IntRange(16, 24).map { i ->
        DisplayItem(
            keyDataRefId = "temp_$i",
            position = IfrButton.Position(1f, 1f),
            size = IfrButton.Size(1f, 1f),
            data = DisplayData.Temperature(i)
        )
    } + listOf("COOL", "HEAT", "FAN").map { mode ->
        DisplayItem(
            keyDataRefId = "mode_$mode",
            data = DisplayData.IconOnly(
                when (mode) {
                    "COOL" -> IconButtonData.IconType.COOL
                    "HEAT" -> IconButtonData.IconType.HEAT
                    "FAN" -> IconButtonData.IconType.FAN
                    else -> error("Wrong mode icon")
                }
            ),
            position = IfrButton.Position(1f, 0f)
        )
    } + List(8) { i ->
        DisplayItem(
            keyDataRefId = "timer_${0.5 * i}",
            position = IfrButton.Position(2f, 0f),
            data = DisplayData.Timer((0.5 * i).hours.inWholeSeconds)
        )
    } + listOf(1, 2, 3, 4).map { speed ->
        DisplayItem(
            keyDataRefId = "fan_speed_$speed",
            position = IfrButton.Position(2f, 3f),
            data = DisplayData.FanPower(speed)
        )
    }
}
