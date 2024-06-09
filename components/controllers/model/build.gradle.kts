

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvm()
    iosX64()
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlin.serialization.json)
        }
    }
}
