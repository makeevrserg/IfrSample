package com.flipperdevices.ifrmvp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * [IfrKeyData] is used to define the remote controller key
 *
 * For example, the .ir file contains multiple buttons. We need to use the ON/OFF buttons.
 * Then we define [IfrKeyData.RawDataHash] where [IfrKeyData.RawDataHash.value] is the hashcode of its raw data.
 * It's required, so we can find exact signal by its identifier
 *
 * The class should be polymorphic, so we can define different identifiers for future development.
 */
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
