package org.company.panel.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Power
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import org.company.panel.model.Item
import org.company.panel.model.PanelButtonType

@Composable
private fun LayoutItemComposable(item: Item) {
    item.containerInfo?.let { containerInfo ->
        LayoutComposable(
            containerInfo = containerInfo,
            content = {
                item.items.forEach { item ->
                    ItemComposable(item)
                }
            }
        )
    }
}

@Composable
fun <T> Modifier.ifNotNull(value: T?, builder: @Composable Modifier.(T) -> Modifier): Modifier {
    return if (value == null) this
    else this.then(builder.invoke(this, value))
}


@Composable
fun Modifier.thenIf(predicate: () -> Boolean, builder: @Composable Modifier.() -> Modifier): Modifier {
    return if (!predicate.invoke()) this
    else this.then(builder.invoke(this))
}

@Composable
fun Modifier.thenIf(predicate: Boolean, builder: @Composable Modifier.() -> Modifier): Modifier {
    return if (!predicate) this
    else this.then(builder.invoke(this))
}

@Composable
private fun ButtonItemComposable(item: Item) {
    val isClickable = when (item.itemType) {
        PanelButtonType.POWER_TOGGLE,
        PanelButtonType.HOME_BUTTON,
        PanelButtonType.UP_BUTTON,
        PanelButtonType.DOWN_BUTTON -> true

        PanelButtonType.TEXT_BUTTON,
        PanelButtonType.UNKNOWN,
        null -> false
    }
    Box(
        modifier = Modifier
            .ifNotNull(item.size) { size -> Modifier.size(size.dp) }
            .ifNotNull(item.clipRadius) { clip -> Modifier.clip(RoundedCornerShape(clip.dp)) }
            .ifNotNull(item.backgroundColor) { color -> Modifier.background(Color(color)) }
            .thenIf(isClickable) { clickable { } },
        contentAlignment = Alignment.Center
    ) {
        val icon = when (item.itemType) {
            PanelButtonType.POWER_TOGGLE -> Icons.Filled.Power
            PanelButtonType.HOME_BUTTON -> Icons.Filled.Home
            PanelButtonType.UP_BUTTON -> Icons.Filled.ArrowUpward
            PanelButtonType.DOWN_BUTTON -> Icons.Filled.ArrowDownward
            PanelButtonType.TEXT_BUTTON -> null
            PanelButtonType.UNKNOWN -> null
            null -> null
        }
        icon?.let { localIcon ->
            Icon(
                painter = rememberVectorPainter(localIcon),
                tint = item.iconTint?.let(::Color) ?: MaterialTheme.colors.onPrimary,
                contentDescription = null
            )
        }
        item.text.firstOrNull()?.let { text ->
            Text(
                text = text.value,
                color = item.textColor?.let(::Color) ?: MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.overline
            )
        }
    }
}

@Composable
fun ItemComposable(item: Item) {
    LayoutItemComposable(item)
    ButtonItemComposable(item)
}