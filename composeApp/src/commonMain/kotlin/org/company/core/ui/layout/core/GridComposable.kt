package org.company.core.ui.layout.core

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.company.grid.ui.content.ButtonsComposable
import org.company.grid.ui.content.DisplayItemsComposable
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
                BoxWithConstraints(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart,
                    content = {
                        DisplayItemsComposable(
                            pageLayout = currentPage,
                            stateToIndex = layout.stateToIndex
                        )
                        ButtonsComposable(
                            pageLayout = currentPage,
                            scaffoldState = scaffoldState,
                            onButtonClicked = gridViewModel::onButtonClicked,
                            onStateButtonClicked = gridViewModel::onStateButtonClicked,
                            stateToIndex = layout.stateToIndex
                        )
                    }
                )
            }
        }
    )
}
