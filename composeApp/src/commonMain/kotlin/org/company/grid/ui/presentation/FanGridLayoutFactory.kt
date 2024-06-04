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
                    displayData = DisplayData(
                        text = "COOL",
                        position = IfrButton.Position(0f, 0f)
                    )
                ),
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "mode_heat",
                        value = "h"
                    ),
                    displayData = DisplayData(
                        text = "HEAT",
                        position = IfrButton.Position(1f, 0f)
                    )
                ),
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "mode_fan",
                        value = "f"
                    ),
                    displayData = DisplayData(
                        text = "FAN",
                        position = IfrButton.Position(2f, 0f)
                    )
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
                    displayData = DisplayData(
                        text = "temp_16",
                        position = IfrButton.Position(2f, 1f)
                    )
                ),
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "temp_17",
                        value = "STUB"
                    ),
                    displayData = DisplayData(
                        text = "temp_17",
                        position = IfrButton.Position(2f, 1f)
                    )
                ),
                IfrKeyState(
                    keyData = IfrKeyData.RawDataHash(
                        id = "temp_18",
                        value = "STUB"
                    ),
                    displayData = DisplayData(
                        text = "temp_18",
                        position = IfrButton.Position(2f, 1f)
                    )
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
                        )
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
