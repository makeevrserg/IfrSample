package org.company.adaptive.ui.components.layout

import androidx.compose.runtime.Composable
import org.company.adaptive.model.Item

@Composable
fun ItemComposable(item: Item) {
    LayoutItemComposable(item)
    ButtonItemComposable(item)
}
