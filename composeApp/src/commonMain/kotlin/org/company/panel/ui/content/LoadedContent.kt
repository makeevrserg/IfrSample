package org.company.panel.ui.content

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.company.panel.model.PanelButtonType
import org.company.panel.presentation.PanelComponent
import org.company.panel.ui.components.HomeButton
import org.company.panel.ui.components.ItemComposable
import org.company.panel.ui.components.LayoutComposable
import org.company.panel.ui.components.PowerButton
import org.company.panel.ui.components.UnknownButton

@Composable
internal fun LoadedContent(model: PanelComponent.Model.Loaded) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        LayoutComposable(
            containerInfo = model.layout.containerInfo,
            content = {
                model.layout.items.forEach { item ->
                    ItemComposable(item)
                }
            }
        )
    }
}