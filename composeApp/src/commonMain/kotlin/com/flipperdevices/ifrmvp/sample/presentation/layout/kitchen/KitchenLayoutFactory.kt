package com.flipperdevices.ifrmvp.sample.presentation.layout.kitchen

import com.flipperdevices.ifrmvp.core.ui.util.GridConstants
import com.flipperdevices.ifrmvp.model.IfrButton
import com.flipperdevices.ifrmvp.model.IfrKeyData
import com.flipperdevices.ifrmvp.model.PageLayout
import com.flipperdevices.ifrmvp.model.PagesLayout
import com.flipperdevices.ifrmvp.model.buttondata.Base64ImageButtonData
import com.flipperdevices.ifrmvp.model.buttondata.ChannelButtonData
import com.flipperdevices.ifrmvp.model.buttondata.IconButtonData
import com.flipperdevices.ifrmvp.model.buttondata.NavigationButtonData
import com.flipperdevices.ifrmvp.model.buttondata.TextButtonData
import com.flipperdevices.ifrmvp.model.buttondata.VolumeButtonData

object KitchenLayoutFactory {
    fun create(): PagesLayout {
        return PagesLayout(
            pages = buildList {
                PageLayout(
                    buttons = buildList {
                        // Sample Text Button
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    value = "power"
                                ),
                                iconType = IconButtonData.IconType.POWER
                            ),
                            position = IfrButton.Position(
                                x = 1f,
                                y = 0f,
                                zIndex = 10f,
                                alignment = IfrButton.Alignment.CENTER,
                            ),
                            size = IfrButton.Size(2f)
                        ).run(::add)
                        // First
                        IfrButton(
                            data = TextButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    value = "power"
                                ),
                                text = "PWR"
                            ),
                            position = IfrButton.Position(0f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = TextButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    value = "menu"
                                ),
                                text = "MENU"
                            ),
                            position = IfrButton.Position(0f, 2f)
                        ).run(::add)
                        IfrButton(
                            data = Base64ImageButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    value = "sample"
                                ),
                                base64Image = GridConstants.TEMP_BASE64_IMAGE
                            ),
                            position = IfrButton.Position(2f, 0f, zIndex = 10f)
                        ).run(::add)
                        IfrButton(
                            data = TextButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    value = "tv_av"
                                ),
                                text = "TV/AV"
                            ),
                            position = IfrButton.Position(0f, 4f)
                        ).run(::add)
                        // Second
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    value = "info"
                                ),
                                iconType = IconButtonData.IconType.INFO
                            ),
                            position = IfrButton.Position(1f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    value = "home"
                                ),
                                iconType = IconButtonData.IconType.HOME
                            ),
                            position = IfrButton.Position(1f, 1f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    value = "back"
                                ),
                                iconType = IconButtonData.IconType.BACK
                            ),
                            position = IfrButton.Position(1f, 3f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    value = "more"
                                ),
                                iconType = IconButtonData.IconType.MORE
                            ),
                            position = IfrButton.Position(1f, 4f)
                        ).run(::add)
                        // Nav
                        IfrButton(
                            data = NavigationButtonData(
                                up = IfrKeyData.RawDataHash(
                                    value = "up"
                                ),
                                left = IfrKeyData.RawDataHash(
                                    value = "left"
                                ),
                                down = IfrKeyData.RawDataHash(
                                    value = "down"
                                ),
                                right = IfrKeyData.RawDataHash(
                                    value = "right"
                                ),
                                ok = IfrKeyData.RawDataHash(
                                    value = "ok"
                                )
                            ),
                            position = IfrButton.Position(3f, 1f),
                            size = IfrButton.Size(
                                width = 3f,
                                height = 3f
                            )
                        ).run(::add)
                        // Channel Volume
                        IfrButton(
                            data = ChannelButtonData(
                                add = IfrKeyData.RawDataHash(
                                    value = "ch+"
                                ),
                                reduce = IfrKeyData.RawDataHash(
                                    value = "ch-"
                                ),
                            ),
                            position = IfrButton.Position(7f, 0f),
                            size = IfrButton.Size(
                                width = 1f,
                                height = 3f
                            )
                        ).run(::add)
                        IfrButton(
                            data = VolumeButtonData(
                                add = IfrKeyData.RawDataHash(
                                    value = "vol+"
                                ),
                                reduce = IfrKeyData.RawDataHash(
                                    value = "vol-"
                                )
                            ),
                            position = IfrButton.Position(7f, 4f),
                            size = IfrButton.Size(
                                width = 1f,
                                height = 3f
                            )
                        ).run(::add)
                        // Bottom Button
                        IfrButton(
                            data = TextButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    value = "123"
                                ),
                                text = "123"
                            ),
                            position = IfrButton.Position(10f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash(
                                    value = "mute"
                                ),
                                iconType = IconButtonData.IconType.MUTE
                            ),
                            position = IfrButton.Position(10f, 4f)
                        ).run(::add)
                    }
                ).run(::add)
            }
        )
    }
}
