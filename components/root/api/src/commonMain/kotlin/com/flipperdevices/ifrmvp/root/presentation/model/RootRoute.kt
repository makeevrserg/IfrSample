package com.flipperdevices.ifrmvp.root.presentation.model

import kotlinx.serialization.Serializable

@Serializable
sealed interface RootRoute {
    @Serializable
    data class Controller(
        val ifrFileId: Long,
        val uiFileId: Long
    ) : RootRoute

    @Serializable
    data object SelectDevice : RootRoute
}
