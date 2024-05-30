package org.company.grid.ui.content

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.company.grid.ui.presentation.GridViewModel

@Composable
fun GridComposable(gridViewModel: GridViewModel) {
    val layout by gridViewModel.layout.collectAsState()
    val currentPage = layout.pagesLayout.pages.firstOrNull()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            currentPage?.let {
                PageComposable(
                    pageLayout = currentPage,
                    scaffoldState = scaffoldState,
                    onButtonClicked = gridViewModel::onButtonClicked,
                    stateToIndex = layout.stateToIndex
                )
            }
        }
    )
}
