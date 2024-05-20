package org.company.adaptive.presentation

import kotlinx.coroutines.flow.StateFlow
import org.company.adaptive.model.Layout

interface PanelComponent {
    val model: StateFlow<Model>

    sealed interface Model {
        data object Loading : Model
        data class Loaded(val layout: Layout) : Model
    }
}
