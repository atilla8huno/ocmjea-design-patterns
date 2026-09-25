plugins {
    java
}

group = "samples"
version = "1.0.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
    implementation("org.hibernate.orm:hibernate-core:7.1.4.Final")
    runtimeOnly("org.postgresql:postgresql:42.7.8")

    testImplementation(platform("org.junit:junit-bom:5.13.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(platform("io.zonky.test.postgres:embedded-postgres-binaries-bom:17.6.0"))
    testImplementation("io.zonky.test:embedded-postgres:2.2.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
