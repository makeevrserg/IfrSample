package org.company.panel.presentation

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.company.core.IoCoroutineScope
import org.company.panel.model.ContainerInfo
import org.company.panel.model.Item
import org.company.panel.model.Layout
import org.company.panel.model.PanelButtonType

class PanelViewModel : PanelComponent, CoroutineScope by IoCoroutineScope() {
    private val _model = MutableStateFlow<PanelComponent.Model>(PanelComponent.Model.Loading)
    override val model: StateFlow<PanelComponent.Model> = _model.asStateFlow()

    init {
        _model.update {
            PanelComponent.Model.Loaded(
                layout = Layout(
                    containerInfo = ContainerInfo(
                        backgroundColor = 0xFF202020,
                        clip = 0,
                        box = ContainerInfo.Box(
                            alignment = ContainerInfo.Alignment.CENTER
                        ),
                    ),
                    items = buildList {
                        Item(
                            containerInfo = ContainerInfo(
                                backgroundColor = 0xFF404040,
                                clip = 8,
                                column = ContainerInfo.Column(
                                    verticalArrangement = ContainerInfo.Arrangement.SPACE_BETWEEN,
                                    horizontalAlignment = ContainerInfo.HorizontalAlignment.START,
                                    spacedBy = 0,
                                )
                            ),
                            items = buildList {
                                Item(
                                    itemType = PanelButtonType.UP_BUTTON,
                                    clipRadius = 8,
                                    backgroundColor = 0xFF404040,
                                    iconTint = 0xFFFFFFFF,
                                    size = 64
                                ).run(::add)
                                Item(
                                    itemType = PanelButtonType.TEXT_BUTTON,
                                    clipRadius = 8,
                                    backgroundColor = 0xFF404040,
                                    iconTint = 0xFFFFFFFF,
                                    size = 64,
                                    textColor = 0xFFFFFFFF,
                                    text = listOf(
                                        Item.Text(
                                            country = "US",
                                            value = "CH"
                                        )
                                    )
                                ).run(::add)
                                Item(
                                    itemType = PanelButtonType.DOWN_BUTTON,
                                    clipRadius = 8,
                                    backgroundColor = 0xFF404040,
                                    iconTint = 0xFFFFFFFF,
                                    size = 64
                                ).run(::add)
                            }
                        ).run(::add)
                    }
                ),
            )
        }
    }
}