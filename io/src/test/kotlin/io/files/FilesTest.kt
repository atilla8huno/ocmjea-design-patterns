package io.files

import java.nio.file.Files
import java.nio.file.Path
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

/**
 * Covers classic java.nio.file Path and Files operations: create, list, move and delete.
 */
class FilesTest {
    @Test
    fun `creates lists moves and deletes`(@TempDir temp: Path) {
        val notes = temp.resolve("notes")
        Files.createDirectories(notes)
        val draft = Files.createFile(notes.resolve("draft.txt"))

        assertTrue(Files.exists(draft))
        assertTrue(Files.isDirectory(notes))
        Files.list(notes).use { paths ->
            assertEquals(listOf(draft), paths.toList())
        }

        val archived = Files.move(draft, notes.resolve("archived.txt"))
        assertFalse(Files.exists(draft))
        assertTrue(Files.deleteIfExists(archived))
    }
}
