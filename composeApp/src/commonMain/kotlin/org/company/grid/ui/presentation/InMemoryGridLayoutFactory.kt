package org.company.grid.ui.presentation

import org.company.grid.model.Button
import org.company.grid.model.PageLayout
import org.company.grid.model.KeyData
import org.company.grid.model.PagesLayout
import org.company.grid.model.buttondata.BackButtonData
import org.company.grid.model.buttondata.ChannelButtonData
import org.company.grid.model.buttondata.HomeButtonData
import org.company.grid.model.buttondata.InfoButtonData
import org.company.grid.model.buttondata.MenuButtonData
import org.company.grid.model.buttondata.MoreButtonData
import org.company.grid.model.buttondata.MuteButtonData
import org.company.grid.model.buttondata.NavigationButtonData
import org.company.grid.model.buttondata.NumbersButtonData
import org.company.grid.model.buttondata.PowerButtonData
import org.company.grid.model.buttondata.TextButtonData
import org.company.grid.model.buttondata.TvAvButtonData
import org.company.grid.model.buttondata.VolumeButtonData

object InMemoryGridLayoutFactory {
    fun create(): PagesLayout {
        return PagesLayout(
            pages = buildList {
                PageLayout(
                    buttons = buildList {
                        // Sample Text Button
                        Button(
                            data = TextButtonData(KeyData.RawDataHash("power"), "PWR"),
                            position = Button.Position(0f, 1f)
                        ).run(::add)
                        // First
                        Button(
                            data = PowerButtonData(KeyData.RawDataHash("power")),
                            position = Button.Position(0f, 0f)
                        ).run(::add)
                        Button(
                            data = MenuButtonData(KeyData.RawDataHash("menu")),
                            position = Button.Position(0f, 2f)
                        ).run(::add)
                        Button(
                            data = TvAvButtonData(KeyData.RawDataHash("tv_av")),
                            position = Button.Position(0f, 4f)
                        ).run(::add)
                        // Second
                        Button(
                            data = InfoButtonData(KeyData.RawDataHash("info")),
                            position = Button.Position(1f, 0f)
                        ).run(::add)
                        Button(
                            data = HomeButtonData(KeyData.RawDataHash("home")),
                            position = Button.Position(1f, 1f)
                        ).run(::add)
                        Button(
                            data = BackButtonData(KeyData.RawDataHash("back")),
                            position = Button.Position(1f, 3f)
                        ).run(::add)
                        Button(
                            data = MoreButtonData(KeyData.RawDataHash("more")),
                            position = Button.Position(1f, 4f)
                        ).run(::add)
                        // Nav
                        Button(
                            data = NavigationButtonData(
                                up = KeyData.RawDataHash("up"),
                                left = KeyData.RawDataHash("left"),
                                down = KeyData.RawDataHash("down"),
                                right = KeyData.RawDataHash("right"),
                                ok = KeyData.RawDataHash("ok")
                            ),
                            position = Button.Position(3f, 1f)
                        ).run(::add)
                        // Channel Volume
                        Button(
                            data = ChannelButtonData(KeyData.RawDataHash("ch+"), KeyData.RawDataHash("ch-")),
                            position = Button.Position(7f, 0f)
                        ).run(::add)
                        Button(
                            data = VolumeButtonData(KeyData.RawDataHash("vol+"), KeyData.RawDataHash("vol-")),
                            position = Button.Position(7f, 4f)
                        ).run(::add)
                        // Bottom Button
                        Button(
                            data = NumbersButtonData(KeyData.RawDataHash("123")),
                            position = Button.Position(10f, 0f)
                        ).run(::add)
                        Button(
                            data = MuteButtonData(KeyData.RawDataHash("mute")),
                            position = Button.Position(10f, 4f)
                        ).run(::add)
                    }
                ).run(::add)
            }
        )
    }
}
