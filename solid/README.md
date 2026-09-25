# SOLID

One package per principle. Run `./gradlew test`.

- **Single responsibility** — a class has one reason to change. Invoice, printer and repository stay apart.
- **Open/closed** — add a discount without editing the calculator.
- **Liskov substitution** — a savings account can stand in for the base account.
- **Interface segregation** — work and eat are separate interfaces so a robot is not forced to eat.
- **Dependency inversion** — the switch depends on `Switchable`, not on a lamp or a fan.
