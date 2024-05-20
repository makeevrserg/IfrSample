package org.company.adaptive.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.company.adaptive.presentation.samsungkitchen.SamsungKitchenLayoutBuilder
import org.company.core.IoCoroutineScope

class PanelViewModel : PanelComponent, CoroutineScope by IoCoroutineScope() {
    private val _model = MutableStateFlow<PanelComponent.Model>(PanelComponent.Model.Loading)
    override val model: StateFlow<PanelComponent.Model> = _model.asStateFlow()

    init {
        _model.update {
            PanelComponent.Model.Loaded(
                layout = SamsungKitchenLayoutBuilder.build().also {
                    println(
                        Json {
                            prettyPrint = true
                        }.encodeToString(it)
                    )
                },
            )
        }
    }
}
