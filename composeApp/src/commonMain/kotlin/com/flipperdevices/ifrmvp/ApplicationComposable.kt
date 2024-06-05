package com.flipperdevices.ifrmvp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.flipperdevices.ifrmvp.sample.presentation.GridViewModel
import com.flipperdevices.ifrmvp.sample.ui.GridComposable

@Composable
internal fun ApplicationComposable() {
//    PanelScreen(panelViewModel = remember { PanelViewModel() })
    GridComposable(remember { GridViewModel() })
}
