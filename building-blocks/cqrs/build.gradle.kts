plugins {
    id("com.microspringboot.java-library")
}

group = "${group}.building-blocks"

dependencies {
    api("net.sizovs:pipelinr:0.8")

    implementation(project(":shared-kernel"))
    implementation("org.springframework.boot:spring-boot-starter-json")
}
