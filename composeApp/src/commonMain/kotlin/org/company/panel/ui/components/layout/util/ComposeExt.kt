package org.company.panel.ui.components.layout.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object ComposeExt {
    @Composable
    fun <T> Modifier.ifNotNull(value: T?, builder: @Composable Modifier.(T) -> Modifier): Modifier {
        return if (value == null) {
            this
        } else {
            this.then(builder.invoke(this, value))
        }
    }

    @Composable
    fun Modifier.thenIf(predicate: () -> Boolean, builder: @Composable Modifier.() -> Modifier): Modifier {
        return if (!predicate.invoke()) {
            this
        } else {
            this.then(builder.invoke(this))
        }
    }

    @Composable
    fun Modifier.thenIf(predicate: Boolean, builder: @Composable Modifier.() -> Modifier): Modifier {
        return if (!predicate) {
            this
        } else {
            this.then(builder.invoke(this))
        }
    }
}
