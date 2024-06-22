package com.flipperdevices.ifrmvp.selectdevice.brands.presentation.feature

import com.flipperdevices.ifrmvp.backend.model.BrandModel
import com.flipperdevices.ifrmvp.selectdevice.brands.presentation.data.BrandsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.astrainteractive.klibs.mikro.extensions.arkivanov.CoroutineFeature

class BrandsListFeature(
    private val brandsRepository: BrandsRepository,
    private val categoryId: Long
) : CoroutineFeature by CoroutineFeature.Main() {
    val state = MutableStateFlow<State>(State.Loading)

    fun tryLoad() = launch {
        state.update { State.Loading }
        brandsRepository.fetchBrands(categoryId)
            .onSuccess { state.value = State.Loaded(it) }
            .onFailure { state.value = State.Error }
            .onFailure(Throwable::printStackTrace)
    }

    init {
        tryLoad()
    }

    sealed interface State {
        data object Loading : State
        data class Loaded(val brands: List<BrandModel>) : State
        data object Error : State
    }
}
