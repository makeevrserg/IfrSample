package org.company.panel.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
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