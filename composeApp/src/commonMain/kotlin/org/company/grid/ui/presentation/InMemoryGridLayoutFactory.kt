package org.company.grid.ui.presentation

import org.company.grid.model.IfrButton
import org.company.grid.model.IfrKeyData
import org.company.grid.model.PageLayout
import org.company.grid.model.PagesLayout
import org.company.grid.model.buttondata.Base64ImageButtonData
import org.company.grid.model.buttondata.ChannelButtonData
import org.company.grid.model.buttondata.IconButtonData
import org.company.grid.model.buttondata.NavigationButtonData
import org.company.grid.model.buttondata.TextButtonData
import org.company.grid.model.buttondata.VolumeButtonData
import org.company.grid.ui.util.GridConstants

object InMemoryGridLayoutFactory {
    fun create(): PagesLayout {
        return PagesLayout(
            pages = buildList {
                PageLayout(
                    buttons = buildList {
                        // Sample Text Button
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash("power"),
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
                                keyData = IfrKeyData.RawDataHash("power"),
                                text = "PWR"
                            ),
                            position = IfrButton.Position(0f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = TextButtonData(
                                keyData = IfrKeyData.RawDataHash("menu"),
                                text = "MENU"
                            ),
                            position = IfrButton.Position(0f, 2f)
                        ).run(::add)
                        IfrButton(
                            data = Base64ImageButtonData(
                                keyData = IfrKeyData.RawDataHash("sample"),
                                base64Image = GridConstants.TEMP_BASE64_IMAGE
                            ),
                            position = IfrButton.Position(2f, 0f, zIndex = 10f)
                        ).run(::add)
                        IfrButton(
                            data = TextButtonData(
                                keyData = IfrKeyData.RawDataHash("tv_av"),
                                text = "TV/AV"
                            ),
                            position = IfrButton.Position(0f, 4f)
                        ).run(::add)
                        // Second
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash("info"),
                                iconType = IconButtonData.IconType.INFO
                            ),
                            position = IfrButton.Position(1f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash("home"),
                                iconType = IconButtonData.IconType.HOME
                            ),
                            position = IfrButton.Position(1f, 1f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash("back"),
                                iconType = IconButtonData.IconType.BACK
                            ),
                            position = IfrButton.Position(1f, 3f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash("more"),
                                iconType = IconButtonData.IconType.MORE
                            ),
                            position = IfrButton.Position(1f, 4f)
                        ).run(::add)
                        // Nav
                        IfrButton(
                            data = NavigationButtonData(
                                up = IfrKeyData.RawDataHash("up"),
                                left = IfrKeyData.RawDataHash("left"),
                                down = IfrKeyData.RawDataHash("down"),
                                right = IfrKeyData.RawDataHash("right"),
                                ok = IfrKeyData.RawDataHash("ok")
                            ),
                            position = IfrButton.Position(3f, 1f),
                            size = IfrButton.Size(
                                width = 3f,
                                height = 3f
                            )
                        ).run(::add)
                        // Channel Volume
                        IfrButton(
                            data = ChannelButtonData(IfrKeyData.RawDataHash("ch+"), IfrKeyData.RawDataHash("ch-")),
                            position = IfrButton.Position(7f, 0f),
                            size = IfrButton.Size(
                                width = 1f,
                                height = 3f
                            )
                        ).run(::add)
                        IfrButton(
                            data = VolumeButtonData(IfrKeyData.RawDataHash("vol+"), IfrKeyData.RawDataHash("vol-")),
                            position = IfrButton.Position(7f, 4f),
                            size = IfrButton.Size(
                                width = 1f,
                                height = 3f
                            )
                        ).run(::add)
                        // Bottom Button
                        IfrButton(
                            data = TextButtonData(
                                keyData = IfrKeyData.RawDataHash("123"),
                                text = "123"
                            ),
                            position = IfrButton.Position(10f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyData = IfrKeyData.RawDataHash("mute"),
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
