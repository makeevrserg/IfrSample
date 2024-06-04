package org.company.grid.ui.presentation.layout.fan

import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.IfrKeyState
import org.company.grid.model.Visibility
import org.company.grid.model.buttondata.StatefulDoubleButtonData

object FanTemperatureButtonFactory {
    fun create() = IfrButton(
        data = StatefulDoubleButtonData(
            text = "TEMP",
            id = "temperature",
            visibility = Visibility.ActiveState(
                dataRefId = "mode",
                stateRefId = "mode_COOL"
            ),
            keyStates = IntRange(16, 24).map { i ->
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "temp_$i",
                        value = "STUB"
                    ),
                )
            },
        ),
        position = IfrButton.Position(
            x = 1f,
            y = 4f,
        ),
        size = IfrButton.Size(
            width = 1f,
            height = 2f
        )
    )
}
