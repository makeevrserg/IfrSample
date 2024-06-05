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
import org.company.grid.model.PageLayout

@Composable
internal fun BoxWithConstraintsScope.ButtonsComposable(
    pageLayout: PageLayout,
    scaffoldState: ScaffoldState,
    onButtonClicked: (IfrButton) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    pageLayout.buttons
        .forEach { button ->
            GridItemComposable(
                modifier = Modifier,
                position = button.position,
                size = button.size,
                content = {
                    ButtonItemComposable(
                        buttonData = button.data,
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
