// == Define locations for build logic ==
pluginManagement {
    repositories {
        gradlePluginPortal() // if pluginManagement.repositories looks like this, it can be omitted as this is the default
    }
    includeBuild("../build-logic")
}

// == Define locations for components ==
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
includeBuild("../platforms")

// == Define the inner structure of this component ==
rootProject.name = "building-blocks"
include("shared-kernel")
include("cqrs")
include("jpa")
//include("annotation")
//include("resilience")
//include("event-bus")
//include("caching")
