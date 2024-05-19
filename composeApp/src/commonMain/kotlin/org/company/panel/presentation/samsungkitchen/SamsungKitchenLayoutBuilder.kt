package org.company.panel.presentation.samsungkitchen

import org.company.panel.model.ContainerInfo
import org.company.panel.model.Item
import org.company.panel.model.Layout
import org.company.panel.presentation.layout.LayoutBuilder

object SamsungKitchenLayoutBuilder : LayoutBuilder {
    override fun build(): Layout {
        return Layout(
            containerInfo = ContainerInfo(
                box = ContainerInfo.Box(
                    alignment = ContainerInfo.Alignment.TOP_CENTER,
                    width = ContainerInfo.WidthContentSize.FILL_WIDTH,
                    height = ContainerInfo.HeightContentSize.FILL_HEIGHT
                ),
            ),
            items = buildList {
                Item(
                    containerInfo = ContainerInfo(
                        column = ContainerInfo.Column(
                            verticalArrangement = ContainerInfo.Arrangement.SPACE_BETWEEN,
                            horizontalAlignment = ContainerInfo.HorizontalAlignment.CENTER,
                            width = ContainerInfo.WidthContentSize.FILL_WIDTH,
                            height = ContainerInfo.HeightContentSize.FILL_HEIGHT,
                            verticalSpacedBy = 0
                        )
                    ),
                    items = listOf(
                        UpperRowItemBuilder.build(),
                        NavButtonItemBuilder.build(),
                        FirstBottomRowItemBuilder.build(),
                        SecondBottomRowItemBuilder.build()
                    )
                ).run(::add)
            }
        )
    }
}
