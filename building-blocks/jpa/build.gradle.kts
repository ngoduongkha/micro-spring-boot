plugins {
    id("com.microspringboot.java-library")
}

group = "${group}.building-blocks"

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation(project(":shared-kernel"))
}
