plugins {
    id("com.microspringboot.commons")
    id("org.springframework.boot") apply false
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    implementation(project(":domain"))

    api("com.microspringboot.building-blocks:jpa")
}
