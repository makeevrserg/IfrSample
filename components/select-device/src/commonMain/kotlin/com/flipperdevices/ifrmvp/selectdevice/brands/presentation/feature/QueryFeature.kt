package com.flipperdevices.ifrmvp.selectdevice.brands.presentation.feature

import kotlinx.coroutines.flow.MutableStateFlow
import ru.astrainteractive.klibs.mikro.extensions.arkivanov.CoroutineFeature

class QueryFeature : CoroutineFeature by CoroutineFeature.Main() {
    val query = MutableStateFlow("")

    fun onQueryChanged(value: String) {
        query.value = value
    }

    fun clearQuery() {
        query.value = ""
    }
}
