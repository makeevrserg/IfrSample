package org.company.panel.ui.components.layout

import androidx.compose.runtime.Composable
import org.company.panel.model.Item

@Composable
fun ItemComposable(item: Item) {
    LayoutItemComposable(item)
    ButtonItemComposable(item)
}
