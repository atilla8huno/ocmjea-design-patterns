package io.text

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

/**
 * Covers classic Java character I/O: Files string helpers and buffered readers/writers.
 */
class TextIoTest {
    @Test
    fun `reads and writes text with Files`(@TempDir temp: Path) {
        val file = temp.resolve("note.txt")
        Files.writeString(file, "hello\n", StandardCharsets.UTF_8)
        Files.writeString(file, "world", StandardCharsets.UTF_8, StandardOpenOption.APPEND)

        assertEquals("hello\nworld", Files.readString(file))
        assertEquals(listOf("hello", "world"), Files.readAllLines(file))
    }

    @Test
    fun `uses buffered character streams`(@TempDir temp: Path) {
        val file = temp.resolve("log.txt")
        Files.newBufferedWriter(file, StandardCharsets.UTF_8).use { writer ->
            writer.write("one")
            writer.newLine()
            writer.write("two")
        }

        Files.newBufferedReader(file, StandardCharsets.UTF_8).use { reader ->
            assertEquals("one", reader.readLine())
            assertEquals("two", reader.readLine())
        }
    }
}
