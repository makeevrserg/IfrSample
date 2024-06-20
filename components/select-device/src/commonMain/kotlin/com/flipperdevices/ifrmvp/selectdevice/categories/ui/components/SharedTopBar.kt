package com.flipperdevices.ifrmvp.selectdevice.categories.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flipperdevices.core.ui.theme.LocalPalletV2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SharedTopBar(
    onBackClicked: (() -> Unit)? = null,
    title: String,
    subtitle: String,
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        actions = actions,
        colors = TopAppBarDefaults
            .centerAlignedTopAppBarColors()
            .copy(
                containerColor = LocalPalletV2.current.surface.navBar.body.accentBrand,
                navigationIconContentColor = LocalPalletV2.current.icon.blackAndWhite.blackOnColor
            ),
        title = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6.copy(fontSize = 18.sp),
                    color = LocalPalletV2.current.text.title.blackOnColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.body2,
                    color = LocalPalletV2.current.text.title.blackOnColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        },
        navigationIcon = navigationIcon@{
            if (onBackClicked == null) return@navigationIcon
            Icon(
                painter = rememberVectorPainter(Icons.Filled.ChevronLeft),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onBackClicked),
                tint = MaterialTheme.colors.onPrimary
            )
        }
    )
}
