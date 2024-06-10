package com.flipperdevices.ifrmvp.sample.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.flipperdevices.ifrmvp.sample.presentation.GridViewModel

@Composable
fun GridComposable(gridViewModel: GridViewModel) {
    val layout by gridViewModel.layout.collectAsState()
    val currentPage = layout.pagesLayout.pages.firstOrNull()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            if (currentPage == null) {
                LoadingView()
            }
            else {
                BoxWithConstraints(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart,
                    content = {
                        ButtonsComposable(
                            pageLayout = currentPage,
                            scaffoldState = scaffoldState,
                            onButtonClicked = {},
                        )
                    }
                )
            }
        }
    )
}

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
