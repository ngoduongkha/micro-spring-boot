import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("com.microspringboot.jacoco")
    id("io.gitlab.arturbosch.detekt")
    kotlin("jvm")
}

group = "com.microspringboot"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

detekt {
    config.setFrom(files("../../../config/detekt/detekt.yml"))
}

dependencies {
    implementation(platform("com.microspringboot.platforms:product-platform"))
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.4")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}
