package org.company.grid.ui.presentation.layout.fan

import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.IfrKeyState
import org.company.grid.model.buttondata.StatefulButtonData

object FanModeButtonFactory {
    fun create() = IfrButton(
        data = StatefulButtonData.StatefulTextButtonData(
            id = "mode",
            keyStates = listOf("COOL", "HEAT", "FAN").map { mode ->
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "mode_$mode",
                        value = "${mode.first()}"
                    ),
                )
            },
            text = "MODE"
        ),
        position = IfrButton.Position(
            x = 4f,
            y = 4f,
        ),
    )
}
