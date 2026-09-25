# I/O

File and stream samples in Kotlin. Classic Java APIs and Kotlin helpers sit in sibling packages. Run `./gradlew test`.

## Classic Java

- **files** — `Path` / `Files`: create, list, move, delete.
- **text** — `Files.writeString` / `readString` and buffered readers/writers.
- **binary** — `FileInputStream` / `FileOutputStream` and `DataInputStream` / `DataOutputStream`.
- **copy** — `Files.copy` and `InputStream.transferTo`.

## Kotlin helpers

- **kotlin_text** — `writeText`, `appendText`, `readText`, `readLines`, `use`.
- **kotlin_binary** — `writeBytes`, `readBytes`, `copyTo`.
