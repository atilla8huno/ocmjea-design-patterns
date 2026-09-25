package io.files

import java.nio.file.Files
import java.nio.file.Path
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

/**
 * java.nio.file Path and Files
 *
 * The modern JDK API for the file system. Path is the location; Files
 * creates directories and files, lists children, moves and deletes.
 * Files.list returns a Stream and must be closed (use / try-with-resources).
 *
 * This test creates a folder, lists it, moves the file and deletes it.
 */
class FilesTest {
    @Test
    fun `creates lists moves and deletes`(@TempDir temp: Path) {
        val notes = temp.resolve("notes")
        Files.createDirectories(notes)
        val draft = Files.createFile(notes.resolve("draft.txt"))

        assertTrue(Files.exists(draft))
        assertTrue(Files.isDirectory(notes))
        // Files.list is a Stream and must be closed
        Files.list(notes).use { paths ->
            assertEquals(listOf(draft), paths.toList())
        }

        val archived = Files.move(draft, notes.resolve("archived.txt"))
        assertFalse(Files.exists(draft))
        assertTrue(Files.deleteIfExists(archived))
    }
}
