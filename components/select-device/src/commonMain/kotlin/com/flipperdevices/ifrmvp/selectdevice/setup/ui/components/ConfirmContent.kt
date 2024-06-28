package com.flipperdevices.ifrmvp.selectdevice.setup.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.flipperdevices.core.ui.theme.LocalPalletV2
import com.flipperdevices.ifrmvp.components.select.device.RemoteSetupR
import dev.icerock.moko.resources.compose.localized
import dev.icerock.moko.resources.desc.desc

@Composable
internal fun ConfirmContent(
    text: String,
    onPositiveClicked: () -> Unit,
    onNegativeClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(LocalPalletV2.current.surface.sheet.body.default),
        content = {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(36.dp)
                        .height(4.dp)
                        .clip(CircleShape)
                        .background(LocalPalletV2.current.surface.contentCard.separator.default)
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.h6,
                    color = LocalPalletV2.current.text.title.blackOnColor,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 42.dp, horizontal = 38.dp)
                ) {
                    Text(
                        text = RemoteSetupR.strings.no.desc().localized(),
                        style = MaterialTheme.typography.body2,
                        color = LocalPalletV2.current.action.blue.text.default,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .clickable(onClick = onNegativeClicked)
                            .padding(vertical = 12.dp, horizontal = 36.dp),
                    )
                    Text(
                        text = RemoteSetupR.strings.yes.desc().localized(),
                        style = MaterialTheme.typography.subtitle2,
                        color = LocalPalletV2.current.action.blue.text.onColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(LocalPalletV2.current.action.blue.background.primary.default)
                            .clickable(onClick = onPositiveClicked)
                            .padding(vertical = 12.dp, horizontal = 36.dp),
                    )
                }
            }
        }
    )
}
