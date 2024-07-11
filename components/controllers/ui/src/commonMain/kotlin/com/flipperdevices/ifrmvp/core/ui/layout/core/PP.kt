package com.flipperdevices.ifrmvp.core.ui.layout.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Number.sf: Dp
    @Composable
    get() = (LocalScaleFactor.current.scaleFactor * this.toFloat()).dp

val Number.sfp: TextUnit
    @Composable
    get() = (this@sfp.toInt() * LocalScaleFactor.current.scaleFactor).sp