package org.company.grid.model.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject
import org.company.grid.model.IfrButton
import org.company.grid.model.RawIfrButton

internal object IfrButtonSerializer : KSerializer<IfrButton> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Flipper.IfrButton") {
        element<IfrButton.Position>("position")
        element<IfrButton.Size>("size")
        element<JsonObject>("data")
    }

    override fun deserialize(decoder: Decoder): IfrButton {
        val rawIfrButton = RawIfrButton.serializer().deserialize(decoder)
        return RawIfrButtonMapper.toIfrButton(rawIfrButton)
    }

    override fun serialize(encoder: Encoder, value: IfrButton) {
        val rawIfrButton = RawIfrButtonMapper.fromIfrButton(value)
        RawIfrButton.serializer().serialize(encoder, rawIfrButton)
    }
}
