package io.copy

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

/**
 * Covers classic Java copy paths: Files.copy and InputStream.transferTo.
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
