package org.company.panel.ui.components.layout

import androidx.compose.runtime.Composable
import org.company.panel.model.Item

@Composable
internal fun LayoutItemComposable(item: Item) {
    item.containerInfo?.let { containerInfo ->
        LayoutComposable(
            containerInfo = containerInfo,
            content = {
                item.items.forEach { item ->
                    ItemComposable(item)
                }
            }
        )
    }
}
