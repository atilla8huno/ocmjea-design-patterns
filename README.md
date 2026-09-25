# JVM reference samples

Independent modules for common JVM topics. Java 21 or Kotlin, JUnit 5, Gradle.

From the repo root, run every module:

```bash
./gradlew test
```

Or open one folder and run `./gradlew test` there.

| Module | Notes |
| --- | --- |
| [design-patterns](design-patterns) | GoF samples |
| [solid](solid) | SOLID principles |
| [coroutines](coroutines) | Kotlin coroutines |
| [spring](spring) | Spring Boot |
| [io](io) | Java and Kotlin I/O |
| [concurrency](concurrency) | Threads, executors, atomics |
| [modern-java](modern-java) | Java 9–21 language features |
| [streams](streams) | Stream API |
| [functional](functional) | `java.util.function`, composition, purity |
| [collections](collections) | Collection types as problems |
| [datetime](datetime) | `java.time` |
| [jpa](jpa) | JPA and Hibernate |

Types live in `src/main`, tests in `src/test`.
