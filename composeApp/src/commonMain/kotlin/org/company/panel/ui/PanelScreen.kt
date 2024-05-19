package org.company.panel.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.company.panel.presentation.PanelComponent
import org.company.panel.presentation.PanelViewModel
import org.company.panel.ui.content.LoadedContent
import org.company.panel.ui.content.LoadingContent

@Composable
internal fun PanelScreen(panelViewModel: PanelViewModel) {
    val model by panelViewModel.model.collectAsState()
    Scaffold {
        when (val localModel = model) {
            PanelComponent.Model.Loading -> {
                LoadingContent()
            }

            is PanelComponent.Model.Loaded -> {
                LoadedContent(model = localModel)
            }
        }
    }
}
