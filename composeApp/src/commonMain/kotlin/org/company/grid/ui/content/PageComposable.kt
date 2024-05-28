package org.company.grid.ui.content

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.company.core.ui.button.ButtonItemComposable
import org.company.grid.model.PageLayout

@Composable
fun PageComposable(
    pageLayout: PageLayout,
    scaffoldState: ScaffoldState
) {
    val coroutineScope = rememberCoroutineScope()
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart,
        content = {
            pageLayout.buttons.forEach { button ->
                GridItemComposable(
                    modifier = Modifier,
                    position = button.position,
                    size = button.size,
                    content = {
                        ButtonItemComposable(
                            buttonData = button.data,
                            onKeyClicked = {
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
