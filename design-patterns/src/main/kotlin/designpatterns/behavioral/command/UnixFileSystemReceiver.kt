package designpatterns.behavioral.command

class UnixFileSystemReceiver : FileSystemReceiver {
    override fun openFile() = println("Opening file on a Unix OS")
    override fun writeFile() = println("Writing file on a Unix OS")
    override fun closeFile() = println("Closing file on a Unix OS")
}
