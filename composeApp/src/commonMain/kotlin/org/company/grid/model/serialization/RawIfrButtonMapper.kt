package org.company.grid.model.serialization

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.company.grid.model.IfrButton
import org.company.grid.model.RawIfrButton
import org.company.grid.model.buttondata.Base64ImageButtonData
import org.company.grid.model.buttondata.ButtonData
import org.company.grid.model.buttondata.ChannelButtonData
import org.company.grid.model.buttondata.IconButtonData
import org.company.grid.model.buttondata.NavigationButtonData
import org.company.grid.model.buttondata.StatefulButtonData
import org.company.grid.model.buttondata.TextButtonData
import org.company.grid.model.buttondata.UnknownButtonData
import org.company.grid.model.buttondata.VolumeButtonData

internal object RawIfrButtonMapper {
    private val json: Json = Json {
        encodeDefaults = true
    }

    private fun toButtonData(jsonObject: JsonObject): ButtonData {
        val type = jsonObject["type"]?.jsonPrimitive?.content
        val buttonType = ButtonData.ButtonType.entries.find { entry -> entry.name == type }
        return when (buttonType) {
            ButtonData.ButtonType.BASE64_IMAGE -> {
                json.decodeFromJsonElement<Base64ImageButtonData>(jsonObject)
            }

            ButtonData.ButtonType.TEXT -> {
                json.decodeFromJsonElement<TextButtonData>(jsonObject)
            }

            ButtonData.ButtonType.CHANNEL -> {
                json.decodeFromJsonElement<ChannelButtonData>(jsonObject)
            }

            ButtonData.ButtonType.NAVIGATION -> {
                json.decodeFromJsonElement<NavigationButtonData>(jsonObject)
            }

            ButtonData.ButtonType.VOLUME -> {
                json.decodeFromJsonElement<VolumeButtonData>(jsonObject)
            }

            ButtonData.ButtonType.STATEFUL_TEXT -> {
                json.decodeFromJsonElement<StatefulButtonData.StatefulTextButtonData>(jsonObject)
            }

            ButtonData.ButtonType.STATEFUL_ICON -> {
                json.decodeFromJsonElement<StatefulButtonData.StatefulTextButtonData>(jsonObject)
            }

            ButtonData.ButtonType.STATEFUL_BASE64 -> {
                json.decodeFromJsonElement<StatefulButtonData.StatefulTextButtonData>(jsonObject)
            }

            ButtonData.ButtonType.UNKNOWN, null -> UnknownButtonData
            ButtonData.ButtonType.ICON -> {
                json.decodeFromJsonElement<IconButtonData>(jsonObject)
            }
        }
    }

    private fun toJsonObject(buttonData: ButtonData): JsonObject {
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

            ButtonData.ButtonType.STATEFUL_ICON -> {
                buttonData as StatefulButtonData.StatefulIconButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonData.ButtonType.STATEFUL_BASE64 -> {
                buttonData as StatefulButtonData.StatefulBase64ImageButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonData.ButtonType.STATEFUL_TEXT -> {
                buttonData as StatefulButtonData.StatefulTextButtonData
                json.encodeToJsonElement(buttonData)
            }

            ButtonData.ButtonType.ICON -> {
                buttonData as IconButtonData
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
