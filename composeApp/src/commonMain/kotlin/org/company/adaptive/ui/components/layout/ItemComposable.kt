package org.company.adaptive.ui.components.layout

import androidx.compose.runtime.Composable
import org.company.adaptive.model.Item
import org.company.core.ui.button.ButtonItemComposable

@Composable
fun ItemComposable(item: Item) {
    LayoutItemComposable(item)
    item.itemData?.buttonType?.let { buttonType ->
        ButtonItemComposable(buttonType)
    }
}
