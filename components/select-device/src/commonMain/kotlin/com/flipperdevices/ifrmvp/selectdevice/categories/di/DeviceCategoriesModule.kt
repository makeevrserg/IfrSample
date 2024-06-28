package com.flipperdevices.ifrmvp.selectdevice.categories.di

import com.flipperdevices.ifrmvp.selectdevice.categories.presentation.decompose.CategoriesDecomposeComponent

interface DeviceCategoriesModule {
    val categoriesDecomposeComponentFactory: CategoriesDecomposeComponent.Factory
}
