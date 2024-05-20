package org.company.adaptive.presentation.samsungkitchen

import org.company.adaptive.model.ContainerInfo
import org.company.adaptive.model.Item
import org.company.adaptive.presentation.layout.ItemBuilder
import org.company.core.model.ButtonType

object FirstRowItemBuilder : ItemBuilder {
    override fun build(): Item {
        return Item(
            containerInfo = ContainerInfo(
                row = ContainerInfo.Row(
                    horizontalArrangement = ContainerInfo.Arrangement.SPACE_BETWEEN,
                    verticalAlignment = ContainerInfo.VerticalAlignment.CENTER,
                    width = ContainerInfo.WidthContentSize.FILL_WIDTH,
                    height = ContainerInfo.HeightContentSize.WRAP_HEIGHT,
                    horizontalSpacedBy = 8
                )
            ),
            items = buildList {
                Item(
                    itemData = Item.ItemData(
                        buttonType = ButtonType.POWER_TOGGLE
                    )
                ).run(::add)
                Item(
                    itemData = Item.ItemData(
                        buttonType = ButtonType.MENU_BUTTON
                    )
                ).run(::add)
                Item(
                    itemData = Item.ItemData(
                        buttonType = ButtonType.TV_AV_BUTTON
                    )
                ).run(::add)
            }
        )
    }
}
