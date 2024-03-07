plugins {
    id("com.microspringboot.commons")
    id("org.springframework.boot") apply false
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    implementation("com.microspringboot.building-blocks:jpa")
    implementation("com.microspringboot.building-blocks:shared-kernel")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
