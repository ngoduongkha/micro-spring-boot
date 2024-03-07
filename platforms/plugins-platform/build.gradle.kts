plugins {
    id("java-platform")
}

group = "com.microspringboot.platforms"

dependencies {
    constraints {
        api("org.springframework.boot:org.springframework.boot.gradle.plugin:3.2.1")
        api("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:2.0.0-Beta2")
        api("org.jetbrains.kotlin.plugin.spring:org.jetbrains.kotlin.plugin.spring.gradle.plugin:2.0.0-Beta2")
        api("org.jetbrains.kotlin.plugin.jpa:org.jetbrains.kotlin.plugin.jpa.gradle.plugin:2.0.0-Beta2")
        api("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.4")
    }
}
