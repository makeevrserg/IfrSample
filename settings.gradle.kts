rootProject.name = "FlipperIFRSample"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":components:api-backend")
include(":components:controllers:model")
include(":components:controllers:grid")
include(":components:controllers:ui")
include(":components:core:theme")
include(":components:core:io")
include(":components:root:impl")
include(":components:root:api")
include(":components:select-device")
include("composeApp")
// Git Projects
includeBuild("backend")
