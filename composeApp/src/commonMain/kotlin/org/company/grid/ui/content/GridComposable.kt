package org.company.grid.ui.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.company.core.ui.button.ButtonItemComposable
import org.company.grid.ui.presentation.GridViewModel

@Composable
fun GridComposable(gridViewModel: GridViewModel) {
    val layout by gridViewModel.layout.collectAsState()
    Box(Modifier.fillMaxSize(), Alignment.TopCenter) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            layout.buttons.forEach { button ->
                GridItemComposable(
                    modifier = Modifier.padding(16.dp),
                    row = button.position.row,
                    column = button.position.column,
                    content = {
                        ButtonItemComposable(button.data.buttonType)
                    }
                )
            }
        }
    }
}
