package designpatterns.behavioral.command

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test

/**
 * Command (Behavioural)
 *
 * Wrap a request as an object. Open, write and close become Command instances
 * bound to a FileSystemReceiver. FileInvoker holds the current command and
 * execute() runs it, so the invoker never knows the concrete action.
 *
 * Applicable when you need undo, queueing or logging of actions. This test
 * opens, writes and closes a file through that invoker.
 */
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
