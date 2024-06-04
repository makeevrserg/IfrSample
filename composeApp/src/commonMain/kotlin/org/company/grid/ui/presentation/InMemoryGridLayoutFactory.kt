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

                                keyData = IfrKeyData.RawDataHash(
                                    id = "power",
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
                                    id = "power2",
                                    value = "power"
                                ),
                                text = "PWR"
                            ),
                            position = IfrButton.Position(0f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = TextButtonData(

                                keyData = IfrKeyData.RawDataHash(
                                    id = "menu",
                                    value = "menu"
                                ),
                                text = "MENU"
                            ),
                            position = IfrButton.Position(0f, 2f)
                        ).run(::add)
                        IfrButton(
                            data = Base64ImageButtonData(

                                keyData = IfrKeyData.RawDataHash(
                                    id = "image",
                                    value = "sample"
                                ),
                                base64Image = GridConstants.TEMP_BASE64_IMAGE
                            ),
                            position = IfrButton.Position(2f, 0f, zIndex = 10f)
                        ).run(::add)
                        IfrButton(
                            data = TextButtonData(

                                keyData = IfrKeyData.RawDataHash(
                                    id = "tv_av",
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
                                    id = "info",
                                    value = "info"
                                ),
                                iconType = IconButtonData.IconType.INFO
                            ),
                            position = IfrButton.Position(1f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(

                                keyData = IfrKeyData.RawDataHash(
                                    id = "home",
                                    value = "home"
                                ),
                                iconType = IconButtonData.IconType.HOME
                            ),
                            position = IfrButton.Position(1f, 1f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(

                                keyData = IfrKeyData.RawDataHash(
                                    id = "back",
                                    value = "back"
                                ),
                                iconType = IconButtonData.IconType.BACK
                            ),
                            position = IfrButton.Position(1f, 3f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(

                                keyData = IfrKeyData.RawDataHash(
                                    id = "more",
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
                                    id = "nav_up",
                                    value = "up"
                                ),
                                left = IfrKeyData.RawDataHash(
                                    id = "nav_left",
                                    value = "left"
                                ),
                                down = IfrKeyData.RawDataHash(
                                    id = "nav_down",
                                    value = "down"
                                ),
                                right = IfrKeyData.RawDataHash(
                                    id = "nav_right",
                                    value = "right"
                                ),
                                ok = IfrKeyData.RawDataHash(
                                    id = "nav_ok",
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
                                    id = "channels_min",
                                    value = "ch+"
                                ),
                                reduce = IfrKeyData.RawDataHash(
                                    id = "channels_more",
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
                                    id = "volumes_plus",
                                    value = "vol+"
                                ),
                                reduce = IfrKeyData.RawDataHash(
                                    id = "volumes_minus",
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
                                    id = "123",
                                    value = "123"
                                ),
                                text = "123"
                            ),
                            position = IfrButton.Position(10f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(

                                keyData = IfrKeyData.RawDataHash(
                                    id = "mute",
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
