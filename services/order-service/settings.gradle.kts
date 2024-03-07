rootProject.name = "order-service"

// == Define locations for build logic ==
pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    includeBuild("../../build-logic")
}

// == Define locations for components ==
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
includeBuild("../../platforms")
includeBuild("../../building-blocks")

// == Define the inner structure of this component ==
include("domain")
include("infra")
include("app")
