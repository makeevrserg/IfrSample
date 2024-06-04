package org.company.grid.ui.presentation.layout.fan

import org.company.grid.model.Display
import org.company.grid.model.IfrButton
import org.company.grid.model.PageLayout
import org.company.grid.model.PagesLayout

object FanLayoutFactory {
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
                        items = FanDisplayItemsFactory.create()
                    ),
                    buttons = buildList {
                        // Sample Text Button
                        FanPowerButtonFactory.create().run(::add)
                        // Fan button
                        FanFanButtonFactory.create().run(::add)
                        FanModeButtonFactory.create().run(::add)
                        FanTemperatureButtonFactory.create().run(::add)
                        FanTimerButtonFactory.create().run(::add)
                    }
                ).run(::add)
            }
        )
    }
}
