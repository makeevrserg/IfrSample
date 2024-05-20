package org.company.grid.ui.presentation

import org.company.grid.model.Button
import org.company.grid.model.GridLayout
import org.company.grid.model.KeyData
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
    fun create(): GridLayout {
        return GridLayout(
            buttons = buildList {
                // Sample Text Button
                Button(
                    data = TextButtonData(KeyData("power"), "PWR"),
                    position = Button.Position(0f, 1f)
                ).run(::add)
                // First
                Button(
                    data = PowerButtonData(KeyData("power")),
                    position = Button.Position(0f, 0f)
                ).run(::add)
                Button(
                    data = MenuButtonData(KeyData("menu")),
                    position = Button.Position(0f, 2f)
                ).run(::add)
                Button(
                    data = TvAvButtonData(KeyData("tv_av")),
                    position = Button.Position(0f, 4f)
                ).run(::add)
                // Second
                Button(
                    data = InfoButtonData(KeyData("info")),
                    position = Button.Position(1f, 0f)
                ).run(::add)
                Button(
                    data = HomeButtonData(KeyData("home")),
                    position = Button.Position(1f, 1f)
                ).run(::add)
                Button(
                    data = BackButtonData(KeyData("back")),
                    position = Button.Position(1f, 3f)
                ).run(::add)
                Button(
                    data = MoreButtonData(KeyData("more")),
                    position = Button.Position(1f, 4f)
                ).run(::add)
                // Nav
                Button(
                    data = NavigationButtonData(
                        up = KeyData("up"),
                        left = KeyData("left"),
                        down = KeyData("down"),
                        right = KeyData("right"),
                        ok = KeyData("ok")
                    ),
                    position = Button.Position(3f, 1f)
                ).run(::add)
                // Channel Volume
                Button(
                    data = ChannelButtonData(KeyData("ch+"), KeyData("ch-")),
                    position = Button.Position(7f, 0f)
                ).run(::add)
                Button(
                    data = VolumeButtonData(KeyData("vol+"), KeyData("vol-")),
                    position = Button.Position(7f, 4f)
                ).run(::add)
                // Bottom Button
                Button(
                    data = NumbersButtonData(KeyData("123")),
                    position = Button.Position(10f, 0f)
                ).run(::add)
                Button(
                    data = MuteButtonData(KeyData("mute")),
                    position = Button.Position(10f, 4f)
                ).run(::add)
            }
        )
    }
}
