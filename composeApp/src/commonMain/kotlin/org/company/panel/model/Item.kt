package org.company.panel.model

class Item(
    val containerInfo: ContainerInfo? = null,
    val itemType: PanelButtonType? = null,
    val clipRadius: Int? = null,
    val backgroundColor: Long? = null,
    val iconTint: Long? = null,
    val size: Int? = null,
    val textColor: Long? = null,
    val text: List<Text> = emptyList(),
    val items: List<Item> = emptyList(),
) {
    class Text(
        val country: String,
        val value: String
    )
}