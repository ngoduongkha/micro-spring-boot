plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(platform("com.microspringboot.platforms:plugins-platform"))

    implementation(project(":commons"))
    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin")
}
