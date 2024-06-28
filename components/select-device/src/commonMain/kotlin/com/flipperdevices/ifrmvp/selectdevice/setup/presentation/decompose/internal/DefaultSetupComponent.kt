package com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.internal

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.decompose.SetupComponent
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.feature.CurrentSignalFeature
import com.flipperdevices.ifrmvp.selectdevice.setup.presentation.feature.HistoryFeature
import ru.astrainteractive.klibs.mikro.core.util.combineStates

class DefaultSetupComponent(
    componentContext: ComponentContext,
    override val param: SetupComponent.Param,
    private val onBackClicked: () -> Unit,
    createCurrentSignalFeature: () -> CurrentSignalFeature,
    createHistoryFeature: () -> HistoryFeature
) : SetupComponent, ComponentContext by componentContext {
    private val signalFeature = instanceKeeper.getOrCreate {
        createCurrentSignalFeature.invoke()
    }
    private val historyFeature = instanceKeeper.getOrCreate {
        createHistoryFeature.invoke()
    }

    override val model = combineStates(
        signalFeature.state,
        transform = { (state) ->
            when (state) {
                CurrentSignalFeature.State.Error -> SetupComponent.Model.Error
                is CurrentSignalFeature.State.Loaded -> {
                    SetupComponent.Model.Loaded(response = state.response)
                }

                CurrentSignalFeature.State.Loading -> SetupComponent.Model.Loading
            }
        }
    )

    override fun tryLoad() {
        signalFeature.load(
            successResults = historyFeature.state.value.successfulSignals,
            failedResults = historyFeature.state.value.failedSignals
        )
    }

    override fun onSuccessClicked() {
        val model = model.value as? SetupComponent.Model.Loaded ?: return
        val signalModel = model.response.signalResponse?.signalModel ?: return
        historyFeature.rememberSuccessful(signalModel)
        tryLoad()
    }

    override fun onFailedClicked() {
        val model = model.value as? SetupComponent.Model.Loaded ?: return
        val signalModel = model.response.signalResponse?.signalModel ?: return
        historyFeature.rememberFailed(signalModel)
        tryLoad()
    }

    // todo
    override fun dispatchSignal() = Unit

    override fun onBackClicked() = onBackClicked.invoke()
}
