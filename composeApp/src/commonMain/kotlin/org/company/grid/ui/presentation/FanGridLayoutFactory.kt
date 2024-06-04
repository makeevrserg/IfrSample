package org.company.grid.ui.presentation

import org.company.grid.model.Display
import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.IfrKeyState
import org.company.grid.model.PageLayout
import org.company.grid.model.PagesLayout
import org.company.grid.model.Visibility
import org.company.grid.model.buttondata.IconButtonData
import org.company.grid.model.buttondata.StatefulButtonData
import org.company.grid.model.buttondata.StatefulDoubleButtonData
import org.company.grid.model.display.DisplayData

object FanGridLayoutFactory {

    private fun getModeButton() = IfrButton(
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

    private fun getTemperatureButton() = IfrButton(
        data = StatefulDoubleButtonData(
            text = "TEMP_C",
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

    private fun getTimerButton() = IfrButton(
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

    private fun getDisplayItems() = IntRange(16, 24).map { i ->
        DisplayData(
            keyDataRefId = "temp_$i",
            text = "$i°",
            position = IfrButton.Position(2f, 1f)
        )
    } + listOf("COOL", "HEAT", "FAN").map { mode ->
        DisplayData(
            keyDataRefId = "mode_$mode",
            text = "$mode",
            position = IfrButton.Position(1f, 0f)
        )
    } + List(8) { i ->
        DisplayData(
            keyDataRefId = "timer_${0.5 * i}",
            text = if (i == 0) "T: OFF" else "${0.5 * i} H",
            position = IfrButton.Position(2f, 0f)
        )
    }

    fun create(): PagesLayout {
        return PagesLayout(
            pages = buildList {
                PageLayout(
                    display = Display(
                        position = IfrButton.Position(
                            y = 0f,
                            x = 0f,
                            alignment = IfrButton.Alignment.TOP_LEFT
                        ),
                        size = IfrButton.Size(
                            width = 5f,
                            height = 3f
                        ),
                        items = getDisplayItems()
                    ),
                    buttons = buildList {
                        // Sample Text Button
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    id = "power",
                                    value = "power"
                                ),
                                iconType = IconButtonData.IconType.POWER,
                            ),
                            position = IfrButton.Position(
                                x = 0f,
                                y = 4f,
                            ),
                        ).run(::add)
                        getModeButton().run(::add)
                        getTemperatureButton().run(::add)
                        getTimerButton().run(::add)
                    }
                ).run(::add)
            }
        )
    }
}
