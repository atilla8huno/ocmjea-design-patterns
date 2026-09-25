package designpatterns.behavioral.command

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test

/** Covers Command by executing open, write, and close through FileInvoker. */
class FileTest {
    @Test
    fun `opens writes and closes a file through commands`() {
        val receiver = FileSystemReceiverUtil.getOperatingSystem()
        val expected = if (System.getProperty("os.name").contains("Windows")) {
            WindowsFileSystemReceiver::class.java
        } else {
            UnixFileSystemReceiver::class.java
        }
        assertInstanceOf(expected, receiver)

        assertDoesNotThrow {
            FileInvoker(OpenFileCommand(receiver)).execute()
            FileInvoker(WriteFileCommand(receiver)).execute()
            FileInvoker(CloseFileCommand(receiver)).execute()
        }
    }
}
