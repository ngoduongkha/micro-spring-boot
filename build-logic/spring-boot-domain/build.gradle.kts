plugins {
    `kotlin-dsl` // <1>
}

dependencies {
    implementation(platform("com.microspringboot.platforms:plugins-platform")) // <2>
    implementation(project(":commons")) // <3>
    implementation("org.springframework.boot:org.springframework.boot.gradle.plugin")  // <4>
    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin")
    implementation("org.jetbrains.kotlin.plugin.spring:org.jetbrains.kotlin.plugin.spring.gradle.plugin")
    implementation("org.jetbrains.kotlin.plugin.jpa:org.jetbrains.kotlin.plugin.jpa.gradle.plugin")
}
