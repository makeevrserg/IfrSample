package org.company.adaptive.model

import kotlinx.serialization.Serializable

@Serializable
class Layout(
    val containerInfo: ContainerInfo,
    val items: List<Item>
)
