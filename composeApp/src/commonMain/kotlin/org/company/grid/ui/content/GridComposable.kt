package org.company.grid.ui.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.company.core.ui.button.ButtonItemComposable
import org.company.grid.ui.presentation.GridViewModel

@Composable
fun GridComposable(gridViewModel: GridViewModel) {
    val layout by gridViewModel.layout.collectAsState()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            Box(Modifier.fillMaxSize(), Alignment.TopCenter) {
                BoxWithConstraints(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ) {
                    layout.pagesLayout.pages
                        .firstOrNull()
                        ?.buttons
                        .orEmpty()
                        .forEach { button ->
                            GridItemComposable(
                                modifier = Modifier.padding(16.dp),
                                row = button.position.row,
                                column = button.position.column,
                                content = {
                                    ButtonItemComposable(
                                        buttonData = button.data,
                                        onKeyClicked = {
                                            coroutineScope.launch {
                                                scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                                                scaffoldState.snackbarHostState.showSnackbar("Clicked: ${it}")
                                            }
                                        }
                                    )
                                }
                            )
                        }
                }
            }
        }
    )
}
