package org.company.panel.ui.content

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.company.app.theme.AppTheme
import org.company.core.ui.layout.ItemComposable
import org.company.core.ui.layout.LayoutComposable
import org.company.panel.presentation.PanelComponent

@Composable
internal fun LoadedContent(model: PanelComponent.Model.Loaded) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize().padding(AppTheme.dimens.M),
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
