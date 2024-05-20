package org.company.grid.ui.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.company.core.IoCoroutineScope
import org.company.core.model.ButtonType
import org.company.grid.model.Button
import org.company.grid.model.GridLayout
import org.company.grid.model.NavigationButtonData
import org.company.grid.model.SingleKeyButtonType

class GridViewModel : CoroutineScope by IoCoroutineScope() {
    val layout = MutableStateFlow<GridLayout>(GridLayout(buttons = emptyList()))

    init {
        layout.update {
            GridLayout(
                buttons = buildList {
                    // First
                    Button(
                        data = SingleKeyButtonType("KEY", ButtonType.POWER_TOGGLE),
                        position = Button.Position(0f, 0f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType("KEY", ButtonType.MENU_BUTTON),
                        position = Button.Position(0f, 2f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType("KEY", ButtonType.TV_AV_BUTTON),
                        position = Button.Position(0f, 4f)
                    ).run(::add)
                    // Second
                    Button(
                        data = SingleKeyButtonType("KEY", ButtonType.INFO),
                        position = Button.Position(1f, 0f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType("KEY", ButtonType.HOME_BUTTON),
                        position = Button.Position(1f, 1f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType("KEY", ButtonType.BACK),
                        position = Button.Position(1f, 3f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType("KEY", ButtonType.MORE),
                        position = Button.Position(1f, 4f)
                    ).run(::add)
                    // Nav
                    Button(
                        data = NavigationButtonData(
                            up = "up",
                            left = "left",
                            down = "down",
                            right = "right",
                            ok = "ok"
                        ),
                        position = Button.Position(3f, 1f)
                    ).run(::add)
                    // Channel Volume
                    Button(
                        data = SingleKeyButtonType("KEY", ButtonType.BUTTON_CH),
                        position = Button.Position(7f, 0f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType("KEY", ButtonType.BUTTON_VOL),
                        position = Button.Position(7f, 4f)
                    ).run(::add)
                    // Bottom Button
                    Button(
                        data = SingleKeyButtonType("KEY", ButtonType.BUTTON_123),
                        position = Button.Position(10f, 0f)
                    ).run(::add)
                    Button(
                        data = SingleKeyButtonType("KEY", ButtonType.MUTE),
                        position = Button.Position(10f, 4f)
                    ).run(::add)
                }
            ).also {
                println(Json { prettyPrint = true }.encodeToString(it))
            }
        }
    }
}
