package org.company.panel.model

import kotlinx.serialization.Serializable

@Serializable
class Item(
    val containerInfo: ContainerInfo? = null,
    val itemData: ItemData? = null,
    val items: List<Item> = emptyList()
) {
    @Serializable
    class ItemData(
        val buttonType: ButtonType
    )

    @Serializable
    class Text(
        val country: String,
        val value: String
    )
}
