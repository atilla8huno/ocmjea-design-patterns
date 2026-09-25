package io.kotlin_text

import java.nio.file.Path
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

/**
 * Kotlin File text helpers
 *
 * writeText, appendText, readText and readLines hide the Writer / Reader
 * and default to UTF-8. Path.toFile() bridges from java.nio.file.
 *
 * This test writes, appends and reads a note, and uses bufferedReader().use
 * so the reader is closed.
 */
class KotlinTextIoTest {
    @Test
    fun `reads and writes text without stream boilerplate`(@TempDir temp: Path) {
        val file = temp.resolve("note.txt").toFile()

        file.writeText("hello\n") // writes UTF-8, no Writer boilerplate
        file.appendText("world")

        assertEquals("hello\nworld", file.readText())
        assertEquals(listOf("hello", "world"), file.readLines())
    }

    @Test
    fun `use closes the reader after iterating lines`(@TempDir temp: Path) {
        val file = temp.resolve("log.txt").toFile()
        file.writeText("one\ntwo\n")

        val lines = file.bufferedReader().use { it.readLines() }

        assertEquals(listOf("one", "two"), lines)
    }
}
