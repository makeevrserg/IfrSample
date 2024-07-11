package com.flipperdevices.ifrmvp.selectdevice.categories.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.flipperdevices.core.ui.theme.FlipperTheme
import com.flipperdevices.core.ui.theme.LocalPalletV2
import com.flipperdevices.ifrmvp.backend.model.CategoryManifest
import com.flipperdevices.ifrmvp.backend.model.CategoryMeta
import com.flipperdevices.ifrmvp.backend.model.DeviceCategory
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun DeviceCategoryComposable(
    deviceCategory: DeviceCategory,
    onClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .clickable { onClicked.invoke() },
        backgroundColor = LocalPalletV2.current.surface.contentCard.body.default,
        shape = RoundedCornerShape(12.dp),
        content = {
            Column(
                modifier = Modifier.padding(vertical = 14.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when {

                    else -> {
                        Icon(
                            painter = rememberVectorPainter(Icons.Filled.Error),
                            contentDescription = null,
                            tint = MaterialTheme.colors.error,
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }

                Text(
                    text = deviceCategory.meta.manifest.displayName,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    )
}

@Preview
@Composable
private fun DeviceCategoryComposablePreview() {
    FlipperTheme {
        DeviceCategoryComposable(
            deviceCategory = DeviceCategory(
                id = 1,
                meta = CategoryMeta(
                    iconPngBase64 = "",
                    iconSvgBase64 = "",
                    manifest = CategoryManifest(
                        displayName = "TVs",
                        singularDisplayName = "TV"
                    )
                )
            ),
            onClicked = {}
        )
    }
}
