package com.flipperdevices.ifrmvp.selectdevice.categories.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.flipperdevices.core.ui.theme.LocalPalletV2

@Composable
internal fun ErrorComposable(onReload: (() -> Unit)? = null) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Error",
                    style = MaterialTheme.typography.subtitle2,
                    color = LocalPalletV2.current.text.title.blackOnColor
                )
                onReload?.let {
                    TextButton(onClick = onReload) {
                        Text(
                            text = "Reload page",
                            style = MaterialTheme.typography.subtitle2,
                            color = LocalPalletV2.current.action.blue.text.default
                        )
                    }
                }
            }
        }
    )
}
