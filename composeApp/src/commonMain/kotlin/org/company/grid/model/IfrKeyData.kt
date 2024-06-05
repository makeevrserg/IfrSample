package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface IfrKeyData {
    /**
     * SHA-256 of raw data
     */
    @SerialName("RAW_DATA_HASH")
    @Serializable
    class RawDataHash(
        @SerialName("value")
        val value: String
    ) : IfrKeyData

    @SerialName("ADDRESS_HASH")
    @Serializable
    class AddressHash(
        @SerialName("value")
        val value: String
    ) : IfrKeyData
}
