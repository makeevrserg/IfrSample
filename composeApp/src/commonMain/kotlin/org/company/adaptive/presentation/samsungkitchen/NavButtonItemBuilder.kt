package org.company.adaptive.presentation.samsungkitchen

import org.company.adaptive.model.ContainerInfo
import org.company.adaptive.model.Item
import org.company.adaptive.presentation.layout.ItemBuilder
import org.company.core.model.ButtonType

object NavButtonItemBuilder : ItemBuilder {
    override fun build(): Item {
        return Item(
            containerInfo = ContainerInfo(
                row = ContainerInfo.Row(
                    horizontalArrangement = ContainerInfo.Arrangement.CENTER,
                    verticalAlignment = ContainerInfo.VerticalAlignment.CENTER,
                    width = ContainerInfo.WidthContentSize.FILL_WIDTH,
                    height = ContainerInfo.HeightContentSize.WRAP_HEIGHT,
                    horizontalSpacedBy = 0
                )
            ),
            items = buildList {
                Item(
                    itemData = Item.ItemData(
                        buttonType = ButtonType.NAV
                    )
                ).run(::add)
            }
        )
    }
}
