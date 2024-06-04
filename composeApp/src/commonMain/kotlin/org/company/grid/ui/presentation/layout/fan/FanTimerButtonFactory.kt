package org.company.grid.ui.presentation.layout.fan

import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.IfrKeyState
import org.company.grid.model.buttondata.StatefulDoubleButtonData

object FanTimerButtonFactory {
    fun create() = IfrButton(
        data = StatefulDoubleButtonData(
            text = "TIMER",
            id = "timer",
            keyStates = List(8) { i ->
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "timer_${0.5 * i}",
                        value = "STUB"
                    ),
                )
            },
        ),
        position = IfrButton.Position(
            x = 3f,
            y = 4f,
        ),
        size = IfrButton.Size(
            width = 1f,
            height = 2f
        )
    )
}
