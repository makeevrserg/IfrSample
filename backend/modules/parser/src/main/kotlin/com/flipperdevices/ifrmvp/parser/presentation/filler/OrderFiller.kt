package com.flipperdevices.ifrmvp.parser.presentation.filler

import com.flipperdevices.ifrmvp.model.IfrKeyIdentifier
import com.flipperdevices.ifrmvp.model.buttondata.SingleKeyButtonData
import com.flipperdevices.ifrmvp.parser.api.SignalTableApi
import com.flipperdevices.ifrmvp.parser.model.OrderModel
import com.flipperdevices.ifrmvp.parser.model.RawIfrRemote

internal class OrderFiller(private val signalTableApi: SignalTableApi) {

    private fun isEquals(rawIfrRemote: RawIfrRemote, orderModel: OrderModel): Boolean {
        val keyIdentifier = when (orderModel.data) {
            is SingleKeyButtonData -> orderModel.data.keyIdentifier
            else -> error("Type ${orderModel.data::class} is not supported")
        }
        return when (keyIdentifier) {
            is IfrKeyIdentifier.Name -> {
                rawIfrRemote.name == keyIdentifier.name
            }

            is IfrKeyIdentifier.Sha256 -> error("Comparison by SHA not supported")
        }
    }

    suspend fun fill(model: Model) = with(model) {
        orderModels
            .filter { orderModel -> isEquals(model.remote, orderModel) }
            .forEach { orderModel ->
                signalTableApi.addOrderModel(
                    orderModel = orderModel,
                    ifrSignalId = ifrSignalId,
                    categoryId = categoryId,
                    brandId = brandId,
                    ifrFileId = ifrFileId
                )
            }
    }

    data class Model(
        val orderModels: List<OrderModel>,
        val remote: RawIfrRemote,
        val ifrSignalId: Long,
        val categoryId: Long,
        val brandId: Long,
        val ifrFileId: Long
    )
}
