package com.flipperdevices.ifrmvp.selectdevice.brands.presentation.feature

import com.flipperdevices.ifrmvp.api.backend.ApiBackend
import com.flipperdevices.ifrmvp.backend.model.BrandModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.astrainteractive.klibs.mikro.extensions.arkivanov.CoroutineFeature
import ru.astrainteractive.klibs.paging.IntPagerCollector
import ru.astrainteractive.klibs.paging.context.IntPageContext
import ru.astrainteractive.klibs.paging.data.CoroutineHandledPagedListDataSource
import kotlin.time.Duration.Companion.milliseconds

class BrandsListFeature(
    private val apiBackend: ApiBackend
) : CoroutineFeature by CoroutineFeature.Main() {
    private val querySharedFlow = MutableSharedFlow<String>()

    val query = MutableStateFlow("")
    val pagingCollector = IntPagerCollector(
        initialPage = 0,
        pager = CoroutineHandledPagedListDataSource<BrandModel, IntPageContext> { pagingState ->
            val page = pagingState.pageContext.page
            val pageSize = pagingState.pageSizeAtLeast
            listOf(BrandModel(id = 1, name = "123TV"))
        }
    )

    fun onQueryChanged(query: String) = launch {
        querySharedFlow.emit(query)
    }

    fun clearQuery() = onQueryChanged("")

    private fun collectQuerySideEffect() {
        querySharedFlow
            .debounce(timeout = 400.milliseconds)
            .onEach {
                query.value = it
                pagingCollector.resetAndJoin()
                pagingCollector.loadNextPage()
            }
            .launchIn(this)
    }

    init {
        collectQuerySideEffect()
    }
}
