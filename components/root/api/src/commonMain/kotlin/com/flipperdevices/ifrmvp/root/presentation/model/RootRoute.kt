package com.flipperdevices.ifrmvp.root.presentation.model

import kotlinx.serialization.Serializable

@Serializable
sealed interface RootRoute {
    @Serializable
    data object Controller : RootRoute

    @Serializable
    data object SelectDevice : RootRoute
}
