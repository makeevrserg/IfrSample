package com.flipperdevices.ifrmvp.selectdevice.setup.presentation.features

import com.flipperdevices.ifrmvp.backend.model.SignalModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import ru.astrainteractive.klibs.mikro.extensions.arkivanov.CoroutineFeature

class HistoryFeature : CoroutineFeature by CoroutineFeature.Main() {
    val state = MutableStateFlow(State())

    fun rememberSuccessful(signalModel: SignalModel) {
        state.update { it.copy(successfulSignals = it.successfulSignals + signalModel.id) }
    }

    fun rememberFailed(signalModel: SignalModel) {
        state.update { it.copy(failedSignals = it.failedSignals + signalModel.id) }
    }

    data class State(
        val successfulSignals: List<Long> = emptyList(),
        val failedSignals: List<Long> = emptyList()
    )
}
