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

include(":components:controllers:model")
include(":components:controllers:ui")
include(":components:core:theme")
include("composeApp")
