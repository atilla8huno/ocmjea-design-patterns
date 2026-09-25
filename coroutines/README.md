# Coroutines

Short samples of the usual coroutine APIs. Run `./gradlew test`.

- **launch** — start work and wait for the `Job`.
- **async** — start work and await a result.
- **withContext** — switch dispatcher for a block.
- **cancel** — stop a coroutine that is still running.
- **Channel** — send values between coroutines.
- **Flow** — a cold stream that emits values as they are collected.
