pluginManagement {
    plugins {
        kotlin("jvm") version "2.2.21"
        kotlin("plugin.spring") version "2.2.21"
        id("org.springframework.boot") version "4.1.1"
        id("io.spring.dependency-management") version "1.1.7"
    }
}

rootProject.name = "jvm-samples"

include(
    "design-patterns",
    "solid",
    "coroutines",
    "spring",
    "io",
    "concurrency",
    "modern-java",
    "streams",
    "collections",
    "datetime",
    "jpa",
    "functional",
)
