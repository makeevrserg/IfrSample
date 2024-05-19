package org.company.core.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.company.panel.model.ContainerInfo
import org.company.panel.ui.util.ArrangementUtil.toComposeAlignment
import org.company.panel.ui.util.ArrangementUtil.toHorizontalArrangement
import org.company.panel.ui.util.ArrangementUtil.toVerticalArrangement

private fun ContainerInfo.WidthContentSize.toModifier() = when (this) {
    ContainerInfo.WidthContentSize.FILL_WIDTH -> Modifier.fillMaxWidth()
    ContainerInfo.WidthContentSize.WRAP_WIDTH -> Modifier.wrapContentWidth()
}

private fun ContainerInfo.HeightContentSize.toModifier() = when (this) {
    ContainerInfo.HeightContentSize.FILL_HEIGHT -> Modifier.fillMaxHeight()
    ContainerInfo.HeightContentSize.WRAP_HEIGHT -> Modifier.wrapContentHeight()
}

@Composable
fun LayoutComposable(
    containerInfo: ContainerInfo,
    content: @Composable () -> Unit
) {
    containerInfo.box?.let { box ->
        Box(
            modifier = Modifier
                .then(box.height.toModifier())
                .then(box.width.toModifier()),
            contentAlignment = box.alignment.toComposeAlignment(),
            propagateMinConstraints = false,
            content = { content.invoke() }
        )
    } ?: containerInfo.column?.let { column ->
        Column(
            modifier = Modifier
                .then(column.height.toModifier())
                .then(column.width.toModifier()),
            horizontalAlignment = column.horizontalAlignment.toComposeAlignment(),
            verticalArrangement = column.verticalArrangement.toVerticalArrangement(column.verticalSpacedBy),
            content = { content.invoke() }
        )
    } ?: containerInfo.row?.let { row ->
        Row(
            modifier = Modifier
                .then(row.height.toModifier())
                .then(row.width.toModifier()),
            horizontalArrangement = row.horizontalArrangement.toHorizontalArrangement(row.horizontalSpacedBy),
            verticalAlignment = row.verticalAlignment.toVerticalArrangement(),
            content = { content.invoke() }
        )
    } ?: content.invoke()
}
