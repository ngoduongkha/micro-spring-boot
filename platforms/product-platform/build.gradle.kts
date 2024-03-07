plugins {
    id("java-platform")
}

group = "com.microspringboot.platforms"

javaPlatform.allowDependencies()

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:3.2.1"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:2023.0.0"))

    constraints {
        api("org.springdoc:springdoc-openapi-starter-webflux-ui:2.3.0")
    }
}
