# Functional

Java functional programming with `java.util.function`, not the Stream API (see [streams](../streams)). Run `./gradlew test`.

- **interfaces** — `Function`, `Predicate`, `Consumer`, `Supplier`, `BiFunction`.
- **composition** — `andThen`, `compose`, `Predicate.and` / `or` / `not`.
- **method_references** — static, instance and constructor references.
- **higher_order** — pass and return functions.
- **pure** — no shared mutable state; same input, same output.
- **custom** — a `@FunctionalInterface` you write yourself.
- **closures** — lambdas capture effectively final locals.
