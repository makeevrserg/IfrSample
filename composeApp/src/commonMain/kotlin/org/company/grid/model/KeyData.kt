package org.company.grid.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface KeyData {
    /**
     * SHA-256 of raw data
     */
    @SerialName("RAW_DATA_HASH")
    @Serializable
    class RawDataHash(val value: String): KeyData

    @SerialName("ADDRESS_HASH")
    @Serializable
    class AddressHash(val value: String): KeyData
}
