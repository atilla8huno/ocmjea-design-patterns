package io.kotlin_binary

import java.nio.file.Path
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

/**
 * Kotlin File byte helpers
 *
 * writeBytes / readBytes and copyTo replace a FileInputStream copy loop.
 * copyTo can overwrite; it returns the number of bytes copied.
 *
 * This test writes a byte array, reads it back and copies the file.
 */
class KotlinBinaryIoTest {
    @Test
    fun `reads and writes bytes without stream boilerplate`(@TempDir temp: Path) {
        val file = temp.resolve("payload.bin").toFile()
        val payload = byteArrayOf(1, 2, 3, 4)

        file.writeBytes(payload)

        assertArrayEquals(payload, file.readBytes())
    }

    @Test
    fun `copies a file in one call`(@TempDir temp: Path) {
        val source = temp.resolve("source.bin").toFile()
        val target = temp.resolve("target.bin").toFile()
        source.writeText("copied")

        source.copyTo(target, overwrite = true)

        assertEquals("copied", target.readText())
    }
}
