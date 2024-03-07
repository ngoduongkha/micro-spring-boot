dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

includeBuild("../platforms")

rootProject.name = "build-logic"
include("commons")
include("java-library")
include("kotlin-library")
include("spring-boot-app")
include("spring-boot-domain")
include("spring-boot-infra")
