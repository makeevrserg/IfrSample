package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface IfrKeyData {
    val id: String

    /**
     * SHA-256 of raw data
     */
    @SerialName("RAW_DATA_HASH")
    @Serializable
    class RawDataHash(
        @SerialName("id")
        override val id: String,
        @SerialName("value")
        val value: String
    ) : IfrKeyData

    @SerialName("ADDRESS_HASH")
    @Serializable
    class AddressHash(
        @SerialName("id")
        override val id: String,
        @SerialName("value")
        val value: String
    ) : IfrKeyData
}
