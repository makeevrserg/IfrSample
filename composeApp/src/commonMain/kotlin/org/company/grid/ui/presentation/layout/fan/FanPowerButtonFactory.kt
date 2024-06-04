package org.company.grid.ui.presentation.layout.fan

import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.buttondata.IconButtonData

object FanPowerButtonFactory {
    fun create() = IfrButton(
        data = IconButtonData(
            keyData = IfrKeyData.RawDataHash(
                id = "power",
                value = "power"
            ),
            iconType = IconButtonData.IconType.POWER,
        ),
        position = IfrButton.Position(
            x = 0f,
            y = 4f,
        ),
    )
}
