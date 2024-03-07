plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(platform("com.microspringboot.platforms:plugins-platform"))
    implementation(project(":commons"))
}
