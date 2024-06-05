package org.company.grid.model.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import org.company.grid.model.IfrButton
import org.company.grid.model.RawIfrButton

internal object IfrButtonSerializer : KSerializer<IfrButton> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(
        serialName = "Flipper.IfrButton",
        builderAction = {
            element<IfrButton.Position>("position")
            element<IfrButton.Size>("size")
            element<JsonObject>("data")
        }
    )

    private val json: Json = Json {
        encodeDefaults = true
    }

    override fun deserialize(decoder: Decoder): IfrButton {
        val rawIfrButton = RawIfrButton.serializer().deserialize(decoder)
        return IfrButton(
            data = ButtonDataDecoder(json).decodeFromJsonObject(rawIfrButton.data),
            position = rawIfrButton.position,
            size = rawIfrButton.size
        )
    }

    override fun serialize(encoder: Encoder, value: IfrButton) {
        val rawIfrButton = RawIfrButton(
            data = ButtonDataEncoder(json).encodeToJsonObject(value.data),
            position = value.position,
            size = value.size
        )
        RawIfrButton.serializer().serialize(encoder, rawIfrButton)
    }
}
