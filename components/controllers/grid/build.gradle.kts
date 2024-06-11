
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
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

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions.freeCompilerArgs.add("-Xexpect-actual-classes")

    sourceSets {
        commonMain.dependencies {
            // compose
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.components.resources)
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
            implementation(projects.components.core.theme)
            implementation(projects.components.core.io)
            implementation(projects.components.controllers.ui)
            implementation(projects.components.controllers.model)
        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

android.namespace = hierarchyGroup
