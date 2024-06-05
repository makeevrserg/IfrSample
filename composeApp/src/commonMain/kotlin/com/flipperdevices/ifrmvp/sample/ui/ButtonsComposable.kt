package com.flipperdevices.ifrmvp.sample.ui

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.flipperdevices.ifrmvp.core.ui.button.ButtonItemComposable
import com.flipperdevices.ifrmvp.core.ui.layout.core.GridItemComposable
import com.flipperdevices.ifrmvp.model.IfrButton
import com.flipperdevices.ifrmvp.model.PageLayout
import kotlinx.coroutines.launch

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
