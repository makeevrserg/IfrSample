package org.company.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.company.grid.ui.content.GridComposable
import org.company.grid.ui.presentation.GridViewModel

@Composable
internal fun ComposeApplication() {
//    PanelScreen(panelViewModel = remember { PanelViewModel() })
    GridComposable(remember { GridViewModel() })
}
