package org.company.grid.ui.content

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.company.core.ui.button.ButtonItemComposable
import org.company.core.ui.layout.DisplayDataComposable
import org.company.core.ui.layout.core.DisplayComposable
import org.company.core.ui.layout.core.GridItemComposable
import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyState
import org.company.grid.model.PageLayout
import org.company.grid.model.Visibility
import org.company.grid.model.buttondata.StatefulButtonData

@Composable
fun PageComposable(
    pageLayout: PageLayout,
    stateToIndex: Map<StatefulButtonData, Int>,
    scaffoldState: ScaffoldState,
    onButtonClicked: (IfrButton) -> Unit,
    onStateButtonClicked: (IfrButton, IfrKeyState) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart,
        content = {
            pageLayout.display?.let { display ->
                DisplayComposable(display) {
                    pageLayout.buttons.forEach { button ->
                        val data = button.data as? StatefulButtonData ?: return@forEach
                        val keyState = data.keyStates[stateToIndex[data] ?: 0]
                        val id = keyState.keyData.id
                        val displayItem = display.items.firstOrNull { it.keyDataRefId == id } ?: return@forEach
                        val isVisible = when (val visibility = data.visibility) {
                            is Visibility.ActiveState -> {
                                val data = pageLayout.buttons
                                    .mapNotNull { it.data as? StatefulButtonData }
                                    .firstOrNull { it.id == visibility.dataRefId }
                                    ?: return@forEach
                                val index = stateToIndex[data] ?: 0
                                data.keyStates[index].keyData.id == visibility.stateRefId
                            }

                            Visibility.Always -> true
                        }
                        if (!isVisible) return@forEach
                        GridItemComposable(
                            position = displayItem.position,
                            size = displayItem.size,
                            maxHeight = maxHeight,
                            maxWidth = maxWidth,
                            maxColumns = display.size.width.toInt(),
                            maxRows = display.size.height.toInt(),
                            content = {
                                DisplayDataComposable(displayItem.data)
                            }
                        )
                    }
                }
                pageLayout.buttons.forEach { button ->
                    val isVisible = when (val visibility = (button.data as? StatefulButtonData)?.visibility) {
                        is Visibility.ActiveState -> {
                            val data = pageLayout.buttons
                                .mapNotNull { it.data as? StatefulButtonData }
                                .firstOrNull { it.id == visibility.dataRefId }
                                ?: return@forEach
                            val index = stateToIndex[data] ?: 0
                            data.keyStates[index].keyData.id == visibility.stateRefId
                        }

                        Visibility.Always -> true
                        null -> true
                    }
                    if (!isVisible) return@forEach
                    GridItemComposable(
                        modifier = Modifier,
                        position = button.position,
                        size = button.size,
                        content = {
                            ButtonItemComposable(
                                buttonData = button.data,
                                stateToIndex = stateToIndex,
                                onKeyStateClicked = { ifrKeyState ->
                                    onStateButtonClicked.invoke(button, ifrKeyState)
                                },
                                onKeyDataClicked = {
                                    onButtonClicked.invoke(button)
                                    coroutineScope.launch {
                                        scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                                        scaffoldState.snackbarHostState.showSnackbar("Clicked: $it")
                                    }
                                }
                            )
                        }
                    )
                }
            }
        }
    )
}
