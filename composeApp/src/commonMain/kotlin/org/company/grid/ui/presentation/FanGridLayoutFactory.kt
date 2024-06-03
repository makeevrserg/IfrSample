package org.company.grid.ui.presentation

import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.IfrKeyState
import org.company.grid.model.PageLayout
import org.company.grid.model.PagesLayout
import org.company.grid.model.buttondata.StatefulButtonData
import org.company.grid.model.buttondata.TextButtonData

object FanGridLayoutFactory {
    fun create(): PagesLayout {
        return PagesLayout(
            pages = buildList {
                PageLayout(
                    buttons = buildList {
                        // Sample Text Button
                        IfrButton(
                            data = TextButtonData(IfrKeyData.RawDataHash("power"), "PWR"),
                            position = IfrButton.Position(
                                x = 0f,
                                y = 4f,
                            ),
                        ).run(::add)
                        IfrButton(
                            data = StatefulButtonData.StatefulTextButtonData(
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
                                ),
                                text = "MODE"
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
