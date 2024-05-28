package org.company.grid.ui.presentation

import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.PageLayout
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
                        IfrButton(
                            data = TextButtonData(IfrKeyData.RawDataHash("power"), "PWR"),
                            position = IfrButton.Position(0f, 1f)
                        ).run(::add)
                        // First
                        IfrButton(
                            data = PowerButtonData(IfrKeyData.RawDataHash("power")),
                            position = IfrButton.Position(0f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = MenuButtonData(IfrKeyData.RawDataHash("menu")),
                            position = IfrButton.Position(0f, 2f)
                        ).run(::add)
                        IfrButton(
                            data = TvAvButtonData(IfrKeyData.RawDataHash("tv_av")),
                            position = IfrButton.Position(0f, 4f)
                        ).run(::add)
                        // Second
                        IfrButton(
                            data = InfoButtonData(IfrKeyData.RawDataHash("info")),
                            position = IfrButton.Position(1f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = HomeButtonData(IfrKeyData.RawDataHash("home")),
                            position = IfrButton.Position(1f, 1f)
                        ).run(::add)
                        IfrButton(
                            data = BackButtonData(IfrKeyData.RawDataHash("back")),
                            position = IfrButton.Position(1f, 3f)
                        ).run(::add)
                        IfrButton(
                            data = MoreButtonData(IfrKeyData.RawDataHash("more")),
                            position = IfrButton.Position(1f, 4f)
                        ).run(::add)
                        // Nav
                        IfrButton(
                            data = NavigationButtonData(
                                up = IfrKeyData.RawDataHash("up"),
                                left = IfrKeyData.RawDataHash("left"),
                                down = IfrKeyData.RawDataHash("down"),
                                right = IfrKeyData.RawDataHash("right"),
                                ok = IfrKeyData.RawDataHash("ok")
                            ),
                            position = IfrButton.Position(3f, 1f)
                        ).run(::add)
                        // Channel Volume
                        IfrButton(
                            data = ChannelButtonData(IfrKeyData.RawDataHash("ch+"), IfrKeyData.RawDataHash("ch-")),
                            position = IfrButton.Position(7f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = VolumeButtonData(IfrKeyData.RawDataHash("vol+"), IfrKeyData.RawDataHash("vol-")),
                            position = IfrButton.Position(7f, 4f)
                        ).run(::add)
                        // Bottom Button
                        IfrButton(
                            data = NumbersButtonData(IfrKeyData.RawDataHash("123")),
                            position = IfrButton.Position(10f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = MuteButtonData(IfrKeyData.RawDataHash("mute")),
                            position = IfrButton.Position(10f, 4f)
                        ).run(::add)
                    }
                ).run(::add)
            }
        )
    }
}
