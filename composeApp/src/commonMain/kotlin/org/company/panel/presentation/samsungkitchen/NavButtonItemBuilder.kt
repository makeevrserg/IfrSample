package org.company.panel.presentation.samsungkitchen

import org.company.panel.model.ButtonType
import org.company.panel.model.ContainerInfo
import org.company.panel.model.Item
import org.company.panel.presentation.layout.ItemBuilder

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
