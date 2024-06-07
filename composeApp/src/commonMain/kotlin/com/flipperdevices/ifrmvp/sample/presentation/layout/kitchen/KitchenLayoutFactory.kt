package com.flipperdevices.ifrmvp.sample.presentation.layout.kitchen

import com.flipperdevices.ifrmvp.core.ui.util.GridConstants
import com.flipperdevices.ifrmvp.model.IfrButton
import com.flipperdevices.ifrmvp.model.IfrKeyIdentifier
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
                                keyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "power",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                iconId = IconButtonData.IconType.POWER
                            ),
                            position = IfrButton.Position(
                                x = 1f,
                                y = 0f,
                                zIndex = 10f,
                                alignment = IfrButton.Alignment.CENTER,
                                containerWidth = 2f,
                            ),
                        ).run(::add)
                        // First
                        IfrButton(
                            data = TextButtonData(
                                keyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "power",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                text = "PWR"
                            ),
                            position = IfrButton.Position(0f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = TextButtonData(
                                keyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "menu",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                text = "MENU"
                            ),
                            position = IfrButton.Position(0f, 2f)
                        ).run(::add)
                        IfrButton(
                            data = Base64ImageButtonData(
                                keyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "power",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                base64Image = GridConstants.TEMP_BASE64_IMAGE
                            ),
                            position = IfrButton.Position(2f, 0f, zIndex = 10f)
                        ).run(::add)
                        IfrButton(
                            data = TextButtonData(
                                keyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "tv_av",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                text = "TV/AV"
                            ),
                            position = IfrButton.Position(0f, 4f)
                        ).run(::add)
                        // Second
                        IfrButton(
                            data = IconButtonData(
                                keyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "info",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                iconId = IconButtonData.IconType.INFO
                            ),
                            position = IfrButton.Position(1f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "hm",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                iconId = IconButtonData.IconType.HOME
                            ),
                            position = IfrButton.Position(1f, 1f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "back",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                iconId = IconButtonData.IconType.BACK
                            ),
                            position = IfrButton.Position(1f, 3f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "more",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                iconId = IconButtonData.IconType.MORE
                            ),
                            position = IfrButton.Position(1f, 4f)
                        ).run(::add)
                        // Nav
                        IfrButton(
                            data = NavigationButtonData(
                                upKeyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "up",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                leftKeyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "left",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                downKeyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "down",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                rightKeyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "right",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                okKeyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "apply",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                )
                            ),
                            position = IfrButton.Position(
                                y = 3f,
                                x = 1f,
                                containerWidth = 3f,
                                containerHeight = 3f
                            ),

                        ).run(::add)
                        // Channel Volume
                        IfrButton(
                            data = ChannelButtonData(
                                addKeyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "ch+",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                reduceKeyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "ch-",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                            ),
                            position = IfrButton.Position(
                                y = 7f,
                                x = 0f,
                                containerWidth = 1f,
                                containerHeight = 3f
                            ),

                        ).run(::add)
                        IfrButton(
                            data = VolumeButtonData(
                                addKeyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "v+",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                reduceKeyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "v-",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                )
                            ),
                            position = IfrButton.Position(
                                y = 7f,
                                x = 4f,
                                containerWidth = 1f,
                                containerHeight = 3f
                            ),

                        ).run(::add)
                        // Bottom Button
                        IfrButton(
                            data = TextButtonData(
                                keyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "123",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                text = "123"
                            ),
                            position = IfrButton.Position(10f, 0f)
                        ).run(::add)
                        IfrButton(
                            data = IconButtonData(
                                keyIdentifier = IfrKeyIdentifier.Sha256(
                                    name = "sound_toggle",
                                    sha256String = "60d18bb96f05eee3bde60a0c3f87b13f74b0c4d3d934d659ef7738f415881740"
                                ),
                                iconId = IconButtonData.IconType.MUTE
                            ),
                            position = IfrButton.Position(10f, 4f)
                        ).run(::add)
                    }
                ).run(::add)
            }
        )
    }
}
