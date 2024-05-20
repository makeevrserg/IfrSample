package org.company.adaptive.presentation.samsungkitchen

import org.company.adaptive.model.ContainerInfo
import org.company.adaptive.model.Item
import org.company.adaptive.presentation.layout.ItemBuilder

object UpperRowItemBuilder : ItemBuilder {
    override fun build(): Item {
        return Item(
            containerInfo = ContainerInfo(
                column = ContainerInfo.Column(
                    verticalArrangement = ContainerInfo.Arrangement.CENTER,
                    horizontalAlignment = ContainerInfo.HorizontalAlignment.CENTER,
                    width = ContainerInfo.WidthContentSize.FILL_WIDTH,
                    height = ContainerInfo.HeightContentSize.WRAP_HEIGHT,
                    verticalSpacedBy = 24
                )
            ),
            items = buildList {
                FirstRowItemBuilder.build().run(::add)
                SecondRowItemBuilder.build().run(::add)
            }
        )
    }
}
