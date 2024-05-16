package org.company.panel.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import org.company.panel.model.ContainerInfo
import org.company.panel.ui.util.ArrangementUtil.toComposeAlignment
import org.company.panel.ui.util.ArrangementUtil.toComposeArrangement

@Composable
fun LayoutComposable(
    containerInfo: ContainerInfo,
    content: @Composable () -> Unit
) {
    containerInfo.box?.let { box ->
        Box(
            modifier = Modifier.fillMaxSize()
                .clip(RoundedCornerShape(containerInfo.clip))
                .background(Color(containerInfo.backgroundColor)),
            contentAlignment = box.alignment.toComposeAlignment(),
            propagateMinConstraints = false,
            content = { content.invoke() }
        )
    } ?: containerInfo.column?.let { column ->
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(containerInfo.clip))
                .background(Color(containerInfo.backgroundColor)),
            horizontalAlignment = column.horizontalAlignment.toComposeAlignment(),
            verticalArrangement = column.verticalArrangement.toComposeArrangement(),
            content = { content.invoke() }
        )
    } ?: content.invoke()
}