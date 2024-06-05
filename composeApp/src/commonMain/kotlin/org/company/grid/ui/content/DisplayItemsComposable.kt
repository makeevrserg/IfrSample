package org.company.grid.ui.content

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.Composable
import org.company.core.ui.layout.DisplayDataComposable
import org.company.core.ui.layout.core.DisplayComposable
import org.company.core.ui.layout.core.GridItemComposable
import org.company.grid.model.IfrButton
import org.company.grid.model.PageLayout
import org.company.grid.model.Visibility
import org.company.grid.model.buttondata.StatefulButtonData
import org.company.grid.model.display.DisplayItem

private fun findDisplayItem(
    button: IfrButton,
    buttons: List<IfrButton>,
    displayItems: List<DisplayItem>,
    stateToIndex: Map<StatefulButtonData, Int>,
): DisplayItem? {
    val data = button.data as? StatefulButtonData ?: return null
    val keyState = data.keyStates[stateToIndex[data] ?: 0]
    val displayItem = displayItems.firstOrNull { it.ref.keyDataId == keyState.keyData.id } ?: return null
    val isVisible = when (val visibility = data.visibility) {
        is Visibility.ActiveState -> {
            val data = buttons
                .mapNotNull { it.data as? StatefulButtonData }
                .firstOrNull { it.id == visibility.ref.buttonDataId }
                ?: return null
            val index = stateToIndex[data] ?: 0
            data.keyStates[index].keyData.id == visibility.ref.keyDataId
        }

        Visibility.Always -> true
    }
    if (!isVisible) return null
    return displayItem
}

@Composable
internal fun BoxWithConstraintsScope.DisplayItemsComposable(
    pageLayout: PageLayout,
    stateToIndex: Map<StatefulButtonData, Int>,
) {
    val display = pageLayout.display ?: return
    DisplayComposable(display) {
        pageLayout.buttons.mapNotNull { button ->
            findDisplayItem(
                button = button,
                buttons = pageLayout.buttons,
                displayItems = display.items,
                stateToIndex = stateToIndex
            )
        }.forEach { displayItem ->
            GridItemComposable(
                position = displayItem.position,
                size = displayItem.size,
                maxHeight = maxHeight,
                maxWidth = maxWidth,
                maxColumns = display.size.width.toInt(),
                maxRows = display.size.height.toInt(),
                content = { DisplayDataComposable(displayItem.data) }
            )
        }
    }
}
