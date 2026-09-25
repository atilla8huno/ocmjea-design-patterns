package designpatterns.behavioral.command

object FileSystemReceiverUtil {
    fun getOperatingSystem(): FileSystemReceiver {
        val osName = System.getProperty("os.name")
        println("Operating System: $osName")
        return if (osName.contains("Windows")) {
            WindowsFileSystemReceiver()
        } else {
            UnixFileSystemReceiver()
        }
    }
}
