plugins {
    id("java-platform")
}

group = "com.microspringboot.platforms"

javaPlatform.allowDependencies()

dependencies {
    api(platform("org.junit:junit-bom:5.7.1"))
}
