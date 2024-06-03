package org.company.grid.ui.presentation

import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.IfrKeyState
import org.company.grid.model.PageLayout
import org.company.grid.model.PagesLayout
import org.company.grid.model.buttondata.ButtonData

object FanGridLayoutFactory {
    fun create(): PagesLayout {
        return PagesLayout(
            pages = buildList {
                PageLayout(
                    buttons = buildList {
                        // Sample Text Button
                        IfrButton(
                            data = ButtonData.TextButtonData(IfrKeyData.RawDataHash("power"), "PWR"),
                            position = IfrButton.Position(
                                x = 0f,
                                y = 4f,
                            ),
                        ).run(::add)
                        IfrButton(
                            data = ButtonData.StateButtonData.Default(
                                keyStates = listOf(
                                    IfrKeyState(
                                        keyData = IfrKeyData.RawDataHash("k"),
                                        value = "COOL"
                                    ),
                                    IfrKeyState(
                                        keyData = IfrKeyData.RawDataHash("h"),
                                        value = "HEAT"
                                    ),
                                    IfrKeyState(
                                        keyData = IfrKeyData.RawDataHash("f"),
                                        value = "FAN"
                                    ),
                                )
                            ),
                            position = IfrButton.Position(
                                x = 4f,
                                y = 4f,
                            ),
                        ).run(::add)
                    }
                ).run(::add)
            }
        )
    }
}
