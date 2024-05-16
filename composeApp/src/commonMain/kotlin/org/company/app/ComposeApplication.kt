package org.company.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.company.panel.presentation.PanelViewModel
import org.company.panel.ui.PanelScreen

@Composable
internal fun ComposeApplication() {
    PanelScreen(panelViewModel = remember { PanelViewModel() })
}