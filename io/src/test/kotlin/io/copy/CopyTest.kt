package io.copy

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

/**
 * Copying files and streams
 *
 * Files.copy copies Path to Path (with REPLACE_EXISTING when needed).
 * InputStream.transferTo writes the whole stream to an OutputStream —
 * useful when you already have the streams open.
 *
 * This test copies a file both ways and checks the destination text.
 */
class CopyTest {
    @Test
    fun `copies a file`(@TempDir temp: Path) {
        val source = temp.resolve("source.txt")
        val target = temp.resolve("target.txt")
        Files.writeString(source, "copied")

        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING)

        assertEquals("copied", Files.readString(target))
    }

    @Test
    fun `copies through streams`(@TempDir temp: Path) {
        val source = temp.resolve("from.bin")
        val target = temp.resolve("to.bin")
        Files.writeString(source, "streamed")

        Files.newInputStream(source).use { input ->
            Files.newOutputStream(target).use { output ->
                input.transferTo(output)
            }
        }

        assertEquals("streamed", Files.readString(target))
    }
}
