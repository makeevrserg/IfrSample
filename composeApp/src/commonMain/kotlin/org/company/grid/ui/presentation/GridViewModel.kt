package org.company.grid.ui.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.company.core.IoCoroutineScope
import org.company.core.model.ButtonType
import org.company.grid.model.Button
import org.company.grid.model.ChannelButtonData
import org.company.grid.model.GridLayout
import org.company.grid.model.KeyData
import org.company.grid.model.NavigationButtonData
import org.company.grid.model.SingleKeyButtonType
import org.company.grid.model.VolumeButtonData

class GridViewModel : CoroutineScope by IoCoroutineScope() {
    val layout = MutableStateFlow<GridLayout>(GridLayout(buttons = emptyList()))

    init {
        layout.update {
            GridLayout(
                buttons = buildList {
                    // First
                    Button(
                        data = SingleKeyButtonType(KeyData("power"), ButtonType.POWER_TOGGLE),
                        position = Button.Position(0f, 0f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType(KeyData("menu"), ButtonType.MENU_BUTTON),
                        position = Button.Position(0f, 2f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType(KeyData("tv_av"), ButtonType.TV_AV_BUTTON),
                        position = Button.Position(0f, 4f)
                    ).run(::add)
                    // Second
                    Button(
                        data = SingleKeyButtonType(KeyData("info"), ButtonType.INFO),
                        position = Button.Position(1f, 0f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType(KeyData("home"), ButtonType.HOME_BUTTON),
                        position = Button.Position(1f, 1f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType(KeyData("back"), ButtonType.BACK),
                        position = Button.Position(1f, 3f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType(KeyData("more"), ButtonType.MORE),
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
                        data = SingleKeyButtonType(KeyData("123"), ButtonType.BUTTON_123),
                        position = Button.Position(10f, 0f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType(KeyData("mute"), ButtonType.MUTE),
                        position = Button.Position(10f, 4f)
                    ).run(::add)
                }
            ).also {
                println(Json { prettyPrint = true }.encodeToString(it))
            }
        }
    }
}
