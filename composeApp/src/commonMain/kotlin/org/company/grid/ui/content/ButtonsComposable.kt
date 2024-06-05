package org.company.grid.ui.content

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.company.core.ui.button.ButtonItemComposable
import org.company.core.ui.layout.core.GridItemComposable
import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyState
import org.company.grid.model.PageLayout
import org.company.grid.model.Visibility
import org.company.grid.model.buttondata.StatefulButtonData

private fun isButtonVisible(
    button: IfrButton,
    buttons: List<IfrButton>,
    stateToIndex: Map<String, Int>
): Boolean {
    val isVisible = when (val visibility = (button.data as? StatefulButtonData)?.visibility) {
        is Visibility.ActiveState -> {
            val data = buttons
                .mapNotNull { it.data as? StatefulButtonData }
                .firstOrNull { it.id == visibility.ref.buttonDataId }
                ?: return false
            val index = stateToIndex[data.id] ?: 0
            data.keyStates[index].keyData.id == visibility.ref.keyDataId
        }

        Visibility.Always -> true
        null -> true
    }
    return isVisible
}

@Composable
internal fun BoxWithConstraintsScope.ButtonsComposable(
    pageLayout: PageLayout,
    stateToIndex: Map<String, Int>,
    scaffoldState: ScaffoldState,
    onButtonClicked: (IfrButton) -> Unit,
    onStateButtonClicked: (IfrButton, IfrKeyState) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    pageLayout.buttons
        .filter { button ->
            isButtonVisible(
                button = button,
                stateToIndex = stateToIndex,
                buttons = pageLayout.buttons
            )
        }
        .forEach { button ->
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
