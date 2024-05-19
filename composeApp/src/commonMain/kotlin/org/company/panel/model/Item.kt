package org.company.panel.model

class Item(
    val containerInfo: ContainerInfo? = null,
    val itemData: ItemData? = null,
    val items: List<Item> = emptyList()
) {
    class ItemData(
        val buttonType: ButtonType
    )

    class Text(
        val country: String,
        val value: String
    )
}
