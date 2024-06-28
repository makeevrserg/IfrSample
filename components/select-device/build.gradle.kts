import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import ru.astrainteractive.gradleplugin.property.extension.ModelPropertyValueExt.hierarchyGroup

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.gradle.android.library)
    alias(libs.plugins.klibs.gradle.android.core)
    alias(libs.plugins.moko.resources)
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
            implementation(compose.uiTooling)
            implementation(compose.preview)
            implementation(compose.components.uiToolingPreview)
            // decomppse
            implementation(libs.decompose)
            implementation(libs.decompose.compose)
            implementation(libs.composeImageLoader)
            // klibs
            implementation(libs.klibs.paging)
            implementation(libs.klibs.mikro.core)
            implementation(libs.klibs.mikro.extensions)
            // kotlinx
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlin.serialization.json)
            implementation(libs.kotlinx.io)
            // moko
            implementation(libs.moko.resources.core)
            implementation(libs.moko.resources.compose)
            // Local
            implementation(projects.components.core.theme)
            implementation(projects.components.core.io)
            implementation(projects.components.controllers.ui)
            implementation("com.flipperdevices.ifrmvp.backend:shared-ui-model")
            implementation("com.flipperdevices.ifrmvp.backend:shared-backend-model")
            implementation(projects.components.apiBackend)
        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = hierarchyGroup
    generateResClass = always
}

android.namespace = hierarchyGroup

multiplatformResources {
    resourcesPackage = hierarchyGroup
    resourcesClassName = "RemoteSetupR"
}
