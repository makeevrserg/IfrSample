
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.hierarchyGroup

plugins {
    alias(libs.plugins.multiplatform)
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
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlin.serialization.json)
            implementation(libs.kotlinx.io)
        }
    }
}

android.namespace = hierarchyGroup
