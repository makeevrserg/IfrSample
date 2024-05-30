package org.company.grid.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.company.core.ui.button.ButtonItemComposable
import org.company.grid.model.IfrButton
import org.company.grid.model.PageLayout
import org.company.grid.model.buttondata.StateButtonData

@Composable
fun PageComposable(
    pageLayout: PageLayout,
    stateToIndex: Map<StateButtonData, Int>,
    scaffoldState: ScaffoldState,
    onButtonClicked: (IfrButton) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart,
        content = {
            GridItemComposable(
                modifier = Modifier,
                position = IfrButton.Position(0f, 0f),
                size = IfrButton.Size(5f, 3f),
                content = {
                    Box(
                        Modifier.fillMaxSize()
                            .padding(16.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.CenterStart,
                        content = {
                            pageLayout.buttons
                                .filter { it.data is StateButtonData }
                                .also { println("INSTANCE: ${it.size}") }
                                .forEach { button ->
                                    val stateButtonData = button.data as StateButtonData
                                    val index = stateToIndex.getOrDefault(stateButtonData, 0)
                                    val state = stateButtonData.states[index]
                                    Text(
                                        text = state.value,
                                        color = MaterialTheme.colors.onPrimary,
                                        style = MaterialTheme.typography.button
                                    )
                                }

                        }
                    )
                }
            )
            pageLayout.buttons.forEach { button ->
                GridItemComposable(
                    modifier = Modifier,
                    position = button.position,
                    size = button.size,
                    content = {
                        ButtonItemComposable(
                            buttonData = button.data,
                            onKeyClicked = {
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
    )
}
