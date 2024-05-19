package org.company.panel.presentation

import kotlinx.coroutines.flow.StateFlow
import org.company.panel.model.Layout

interface PanelComponent {
    val model: StateFlow<Model>

    sealed interface Model {
        data object Loading : Model
        data class Loaded(val layout: Layout) : Model
    }
}
