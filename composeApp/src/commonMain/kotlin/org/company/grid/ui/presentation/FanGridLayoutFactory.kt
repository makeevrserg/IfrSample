package org.company.grid.ui.presentation

import org.company.grid.model.Display
import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.IfrKeyState
import org.company.grid.model.PageLayout
import org.company.grid.model.PagesLayout
import org.company.grid.model.buttondata.IconButtonData
import org.company.grid.model.buttondata.StatefulButtonData
import org.company.grid.model.buttondata.StatefulTemperatureButtonData
import org.company.grid.model.display.DisplayData

object FanGridLayoutFactory {

    private fun getModeButton() = IfrButton(
        data = StatefulButtonData.StatefulTextButtonData(
            keyStates = listOf(
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "mode_cool",
                        value = "k"
                    ),
                ),
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "mode_heat",
                        value = "h"
                    ),
                ),
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "mode_fan",
                        value = "f"
                    ),
                ),
            ),
            text = "MODE"
        ),
        position = IfrButton.Position(
            x = 4f,
            y = 4f,
        ),
    )

    private fun getTemperatureButton() = IfrButton(
        data = StatefulTemperatureButtonData(
            keyStates = listOf(
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "temp_16",
                        value = "STUB"
                    ),
                ),
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "temp_17",
                        value = "STUB"
                    ),
                ),
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "temp_18",
                        value = "STUB"
                    ),
                ),
            ),
        ),
        position = IfrButton.Position(
            x = 2f,
            y = 4f,
        ),
        size = IfrButton.Size(
            width = 1f,
            height = 2f
        )
    )

    private fun getDisplayItems() = listOf(
        DisplayData(
            refId = "temp_17",
            text = "temp_17",
            position = IfrButton.Position(2f, 1f)
        ),
        DisplayData(
            refId = "temp_16",
            text = "temp_16",
            position = IfrButton.Position(2f, 1f)
        ),
        DisplayData(
            refId = "temp_18",
            text = "temp_18",
            position = IfrButton.Position(2f, 1f)
        ),
        DisplayData(
            refId = "mode_fan",
            text = "FAN",
            position = IfrButton.Position(2f, 0f)
        ),
        DisplayData(
            refId = "mode_heat",
            text = "HEAT",
            position = IfrButton.Position(1f, 0f)
        ),
        DisplayData(
            refId = "mode_cool",
            text = "COOL",
            position = IfrButton.Position(0f, 0f)
        )
    )

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
                    }
                ).run(::add)
            }
        )
    }
}
