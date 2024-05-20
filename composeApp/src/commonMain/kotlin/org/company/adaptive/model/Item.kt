package org.company.adaptive.model

import kotlinx.serialization.Serializable
import org.company.core.model.ButtonType

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
