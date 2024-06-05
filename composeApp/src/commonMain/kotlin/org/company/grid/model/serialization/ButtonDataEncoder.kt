package org.company.grid.model.serialization

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject
import org.company.grid.model.buttondata.Base64ImageButtonData
import org.company.grid.model.buttondata.ButtonData
import org.company.grid.model.buttondata.ChannelButtonData
import org.company.grid.model.buttondata.IconButtonData
import org.company.grid.model.buttondata.NavigationButtonData
import org.company.grid.model.buttondata.TextButtonData
import org.company.grid.model.buttondata.UnknownButtonData
import org.company.grid.model.buttondata.VolumeButtonData

internal class ButtonDataEncoder(private val json: Json) {
    fun encodeToJsonObject(buttonData: ButtonData): JsonObject {
        return when (buttonData.type) {
            ButtonData.ButtonType.UNKNOWN -> {
                buttonData as UnknownButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonData.ButtonType.BASE64_IMAGE -> {
                buttonData as Base64ImageButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonData.ButtonType.TEXT -> {
                buttonData as TextButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonData.ButtonType.CHANNEL -> {
                buttonData as ChannelButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonData.ButtonType.NAVIGATION -> {
                buttonData as NavigationButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonData.ButtonType.VOLUME -> {
                buttonData as VolumeButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonData.ButtonType.ICON -> {
                buttonData as IconButtonData
                json.encodeToJsonElement(buttonData)
            }
        }.jsonObject
    }
}
