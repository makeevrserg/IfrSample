package org.company.grid.model.serialization

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonPrimitive
import org.company.grid.model.buttondata.Base64ImageButtonData
import org.company.grid.model.buttondata.ButtonData
import org.company.grid.model.buttondata.ChannelButtonData
import org.company.grid.model.buttondata.IconButtonData
import org.company.grid.model.buttondata.NavigationButtonData
import org.company.grid.model.buttondata.StatefulButtonData
import org.company.grid.model.buttondata.StatefulDoubleButtonData
import org.company.grid.model.buttondata.TextButtonData
import org.company.grid.model.buttondata.UnknownButtonData
import org.company.grid.model.buttondata.VolumeButtonData

internal class ButtonDataDecoder(private val json: Json) {
    fun decodeFromJsonObject(jsonObject: JsonObject): ButtonData {
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

            ButtonData.ButtonType.STATEFUL_TEMPERATURE -> {
                json.decodeFromJsonElement<StatefulDoubleButtonData>(jsonObject)
            }
        }
    }
}
