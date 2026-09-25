package io.binary

import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Path
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir

/**
 * Classic Java binary I/O
 *
 * FileInputStream / FileOutputStream move raw bytes. DataInputStream /
 * DataOutputStream add typed primitives (writeInt, readUTF) on top of
 * those streams.
 *
 * This test writes a byte array and a few primitives, then reads them back.
 */
class BinaryIoTest {
    @Test
    fun `writes and reads bytes`(@TempDir temp: Path) {
        val file = temp.resolve("payload.bin")
        val payload = byteArrayOf(1, 2, 3, 4)

        FileOutputStream(file.toFile()).use { it.write(payload) }
        FileInputStream(file.toFile()).use { assertArrayEquals(payload, it.readAllBytes()) }
        assertArrayEquals(payload, Files.readAllBytes(file))
    }

    @Test
    fun `writes and reads primitives`(@TempDir temp: Path) {
        val file = temp.resolve("record.bin")

        DataOutputStream(FileOutputStream(file.toFile())).use { output ->
            output.writeInt(42)
            output.writeUTF("ok")
        }

        DataInputStream(FileInputStream(file.toFile())).use { input ->
            assertEquals(42, input.readInt())
            assertEquals("ok", input.readUTF())
        }
    }
}
