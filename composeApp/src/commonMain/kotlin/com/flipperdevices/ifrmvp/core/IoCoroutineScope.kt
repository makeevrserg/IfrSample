package com.flipperdevices.ifrmvp.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class IoCoroutineScope : CoroutineScope {
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    override val coroutineContext: CoroutineContext = scope.coroutineContext
}
