package com.flipperdevices.ifrmvp.selectdevice.setup.presentation.feature

import com.flipperdevices.ifrmvp.api.backend.ApiBackend
import com.flipperdevices.ifrmvp.backend.model.SignalRequestModel
import com.flipperdevices.ifrmvp.backend.model.SignalRequestModel.SignalResultData
import com.flipperdevices.ifrmvp.backend.model.SignalResponseModel
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.SetupComponent.Param
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.astrainteractive.klibs.mikro.extensions.arkivanov.CoroutineFeature

class CurrentSignalFeature(
    private val apiBackend: ApiBackend,
    private val param: Param
) : CoroutineFeature by CoroutineFeature.Main() {
    val state = MutableStateFlow<State>(State.Loading)

    fun load(
        successResults: List<SignalResultData>,
        failedResults: List<SignalResultData>
    ) = launch {
        state.value = State.Loading
        val result = kotlin.runCatching {
            val request = SignalRequestModel(
                successResults = successResults,
                failedResults = failedResults,
                categoryId = param.categoryId,
                brandId = param.brandId,
            )
            withContext(Dispatchers.IO) {
                delay(1000L)
                apiBackend.getSignal(request)
            }
        }
        result
            .onFailure { state.value = State.Error }
            .onFailure(Throwable::printStackTrace)
            .onSuccess { state.value = State.Loaded(it) }
    }

    init {
        load(emptyList(), emptyList())
    }

    sealed interface State {
        data object Loading : State
        data object Error : State
        data class Loaded(val response: SignalResponseModel) : State
    }
}
