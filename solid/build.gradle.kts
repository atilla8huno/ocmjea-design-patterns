plugins {
    kotlin("jvm")
}

group = "samples"
version = "1.0.0"

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.13.4")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
