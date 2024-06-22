package com.flipperdevices.ifrmvp.selectdevice.categories.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.flipperdevices.core.ui.theme.FlipperTheme
import com.flipperdevices.core.ui.theme.LocalPalletV2
import com.flipperdevices.ifrmvp.backend.model.DeviceCategory
import com.flipperdevices.ifrmvp.backend.model.DeviceCategoryType
import com.flipperdevices.ifrmvp.components.select.device.Res
import com.flipperdevices.ifrmvp.components.select.device.ic_air_conditioner
import com.flipperdevices.ifrmvp.components.select.device.ic_av_receiver
import com.flipperdevices.ifrmvp.components.select.device.ic_camera
import com.flipperdevices.ifrmvp.components.select.device.ic_dvd_player
import com.flipperdevices.ifrmvp.components.select.device.ic_fan
import com.flipperdevices.ifrmvp.components.select.device.ic_projector
import com.flipperdevices.ifrmvp.components.select.device.ic_set_top_box
import com.flipperdevices.ifrmvp.components.select.device.ic_smart_box
import com.flipperdevices.ifrmvp.components.select.device.ic_tv
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private fun DeviceCategoryType.asDrawableResource(): DrawableResource = when (this) {
    DeviceCategoryType.TV -> Res.drawable.ic_tv
    DeviceCategoryType.AIR_CONDITIONER -> Res.drawable.ic_air_conditioner
    DeviceCategoryType.SET_TOP_BOX -> Res.drawable.ic_set_top_box
    DeviceCategoryType.CAMERA -> Res.drawable.ic_camera
    DeviceCategoryType.FAN -> Res.drawable.ic_fan
    DeviceCategoryType.A_V_RECEIVER -> Res.drawable.ic_av_receiver
    DeviceCategoryType.DVD_PLAYER -> Res.drawable.ic_dvd_player
    DeviceCategoryType.SMART_BOX -> Res.drawable.ic_smart_box
    DeviceCategoryType.PROJECTOR -> Res.drawable.ic_projector
    DeviceCategoryType.UNKNOWN -> Res.drawable.ic_projector // todo
}

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
                Icon(
                    painter = painterResource(deviceCategory.type.asDrawableResource()),
                    contentDescription = null,
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.size(36.dp)
                )
                Text(
                    text = deviceCategory.displayName,
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
                displayName = "TV",
                type = DeviceCategoryType.TV
            ),
            onClicked = {}
        )
    }
}
