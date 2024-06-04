package org.company.grid.ui.content

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.company.core.ui.button.ButtonItemComposable
import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyState
import org.company.grid.model.PageLayout
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
                        val displayData = display.items.firstOrNull { it.refId == id } ?: return@forEach
                        GridItemComposable(
                            position = displayData.position,
                            size = IfrButton.Size(1f, 1f),
                            maxHeight = maxHeight,
                            maxWidth = maxWidth,
                            maxColumns = display.size.width.toInt(),
                            maxRows = display.size.height.toInt(),
                            content = {
                                Text(
                                    text = displayData.text,
                                    color = MaterialTheme.colors.onPrimary,
                                    style = MaterialTheme.typography.button
                                )
                            }
                        )
                    }
                }
                pageLayout.buttons.forEach { button ->
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
