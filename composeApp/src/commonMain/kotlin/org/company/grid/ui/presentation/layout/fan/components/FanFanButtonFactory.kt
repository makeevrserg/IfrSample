package org.company.grid.ui.presentation.layout.fan.components

import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.IfrKeyState
import org.company.grid.model.Visibility
import org.company.grid.model.buttondata.StatefulButtonData
import org.company.grid.model.display.ButtonReference

object FanFanButtonFactory {
    fun create() = IfrButton(
        data = StatefulButtonData.StatefulTextButtonData(
            id = "fan",
            visibility = Visibility.ActiveState(
                ref = ButtonReference.ButtonAndKeyData(
                    buttonDataId = "mode",
                    keyDataId = "mode_COOL"
                )
            ),
            keyStates = listOf(1, 2, 3, 4).map { speed ->
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "fan_speed_$speed",
                        value = "$speed"
                    ),
                )
            },
            text = "FAN"
        ),
        position = IfrButton.Position(
            x = 0f,
            y = 5f,
        ),
    )
}
