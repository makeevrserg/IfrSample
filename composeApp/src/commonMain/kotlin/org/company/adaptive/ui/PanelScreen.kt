package org.company.adaptive.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.company.adaptive.presentation.PanelComponent
import org.company.adaptive.presentation.PanelViewModel
import org.company.adaptive.ui.content.LoadedContent
import org.company.adaptive.ui.content.LoadingContent

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
