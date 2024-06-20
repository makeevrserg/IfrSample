import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.hierarchyGroup

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.gradle.android.library)
    alias(libs.plugins.klibs.gradle.android.core)
}

kotlin {
    jvm()
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            // decomppse
            implementation(libs.decompose)
            implementation(libs.decompose.compose)
            implementation(libs.composeImageLoader)
            // mikro
            implementation(libs.klibs.mikro.core)
            implementation(libs.klibs.mikro.extensions)
            // kotlinx
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlin.serialization.json)
            implementation(libs.kotlinx.io)
            // Local
            implementation(projects.components.controllers.grid)
            implementation(projects.components.core.io)
            implementation(projects.components.root.api)
            implementation(projects.components.selectDevice)
            implementation(projects.components.apiBackend)
            implementation(projects.components.core.theme)
        }
    }
}

android.namespace = hierarchyGroup
