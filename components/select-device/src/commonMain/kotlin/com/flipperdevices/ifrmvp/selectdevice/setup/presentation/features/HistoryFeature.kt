package com.flipperdevices.ifrmvp.selectdevice.setup.presentation.features

import com.flipperdevices.ifrmvp.backend.model.SignalModel
import com.flipperdevices.ifrmvp.backend.model.SignalRequestModel.SignalResultData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import ru.astrainteractive.klibs.mikro.extensions.arkivanov.CoroutineFeature

class HistoryFeature : CoroutineFeature by CoroutineFeature.Main() {
    val state = MutableStateFlow(State())

    fun rememberSuccessful(signalModel: SignalModel) {
        val signalResultData = SignalResultData(
            signalId = signalModel.id,
            ifrFileId = signalModel.irFileId
        )
        state.update { it.copy(successfulSignals = it.successfulSignals + signalResultData) }
    }

    fun rememberFailed(signalModel: SignalModel) {
        val signalResultData = SignalResultData(
            signalId = signalModel.id,
            ifrFileId = signalModel.irFileId
        )
        state.update { it.copy(failedSignals = it.failedSignals + signalResultData) }
    }

    data class State(
        val successfulSignals: List<SignalResultData> = emptyList(),
        val failedSignals: List<SignalResultData> = emptyList()
    )
}
