package com.flipperdevices.ifrmvp.grid.ui

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.flipperdevices.ifrmvp.core.ui.button.ButtonItemComposable
import com.flipperdevices.ifrmvp.core.ui.layout.core.GridItemComposable
import com.flipperdevices.ifrmvp.model.IfrButton
import com.flipperdevices.ifrmvp.model.IfrKeyIdentifier
import com.flipperdevices.ifrmvp.model.PageLayout
import kotlinx.coroutines.launch

@Composable
internal fun BoxWithConstraintsScope.ButtonsComposable(
    pageLayout: PageLayout,
    onButtonClicked: (IfrButton, IfrKeyIdentifier) -> Unit,
) {
    pageLayout.buttons
        .forEach { button ->
            GridItemComposable(
                modifier = Modifier,
                position = button.position,
                content = {
                    ButtonItemComposable(
                        buttonData = button.data,
                        onKeyDataClicked = { keyIdentifier ->
                            onButtonClicked.invoke(button,keyIdentifier)
                        }
                    )
                }
            )
        }
}
