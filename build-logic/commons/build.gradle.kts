plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(platform("com.microspringboot.platforms:plugins-platform"))
    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin")
}