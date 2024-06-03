package org.company.grid.model.serialization

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.company.grid.model.IfrButton
import org.company.grid.model.RawIfrButton
import org.company.grid.model.buttondata.ButtonData
import org.company.grid.model.buttondata.ButtonType
import org.company.grid.model.buttondata.ChannelButtonData
import org.company.grid.model.buttondata.NavigationButtonData
import org.company.grid.model.buttondata.VolumeButtonData

internal object RawIfrButtonMapper {
    private val json: Json = Json {
        encodeDefaults = true
    }

    private fun toButtonData(jsonObject: JsonObject): ButtonData {
        val type = jsonObject["type"]?.jsonPrimitive?.content
        val buttonType = ButtonType.entries.find { entry -> entry.name == type }
        return when (buttonType) {
            ButtonType.BASE64_IMAGE -> {
                json.decodeFromJsonElement<ButtonData.Base64ImageButtonData>(jsonObject)
            }

            ButtonType.TEXT -> {
                json.decodeFromJsonElement<ButtonData.TextButtonData>(jsonObject)
            }

            ButtonType.CHANNEL -> {
                json.decodeFromJsonElement<ChannelButtonData>(jsonObject)
            }

            ButtonType.NAVIGATION -> {
                json.decodeFromJsonElement<NavigationButtonData>(jsonObject)
            }

            ButtonType.VOLUME -> {
                json.decodeFromJsonElement<VolumeButtonData>(jsonObject)
            }

            ButtonType.STATEFUL -> {
                json.decodeFromJsonElement<ButtonData.StateButtonData.Default>(jsonObject)
            }

            ButtonType.UNKNOWN, null -> ButtonData.UnknownButtonData
            ButtonType.ICON -> {
                json.decodeFromJsonElement<ButtonData.IconButtonData>(jsonObject)
            }
        }
    }

    private fun toJsonObject(buttonData: ButtonData): JsonObject {
        return when (buttonData.type) {
            ButtonType.UNKNOWN -> {
                buttonData as ButtonData.UnknownButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonType.BASE64_IMAGE -> {
                buttonData as ButtonData.Base64ImageButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonType.TEXT -> {
                buttonData as ButtonData.TextButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonType.CHANNEL -> {
                buttonData as ChannelButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonType.NAVIGATION -> {
                buttonData as NavigationButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonType.VOLUME -> {
                buttonData as VolumeButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonType.STATEFUL -> {
                buttonData as ButtonData.StateButtonData.Default
                json.encodeToJsonElement(buttonData)
            }

            ButtonType.ICON -> {
                buttonData as ButtonData.IconButtonData
                json.encodeToJsonElement(buttonData)
            }
        }.jsonObject
    }

    fun toIfrButton(rawIfrButton: RawIfrButton): IfrButton {
        return IfrButton(
            data = toButtonData(rawIfrButton.data),
            position = rawIfrButton.position,
            size = rawIfrButton.size
        )
    }

    fun fromIfrButton(ifrButton: IfrButton): RawIfrButton {
        return RawIfrButton(
            data = toJsonObject(ifrButton.data),
            position = ifrButton.position,
            size = ifrButton.size
        )
    }
}
