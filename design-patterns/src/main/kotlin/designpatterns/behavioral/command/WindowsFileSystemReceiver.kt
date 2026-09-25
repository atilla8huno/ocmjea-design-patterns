package designpatterns.behavioral.command

class WindowsFileSystemReceiver : FileSystemReceiver {
    override fun openFile() = println("Opening file on a Windows OS")
    override fun writeFile() = println("Writing file on a Windows OS")
    override fun closeFile() = println("Closing file on a Windows OS")
}
