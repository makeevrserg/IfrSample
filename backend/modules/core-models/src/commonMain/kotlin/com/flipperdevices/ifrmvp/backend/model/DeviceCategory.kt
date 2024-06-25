package com.flipperdevices.ifrmvp.backend.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("DeviceCategory")
class DeviceCategory(
    val id: Long,
    val displayName: String,
    val type: DeviceCategoryType,
    val meta: CategoryMeta
)
