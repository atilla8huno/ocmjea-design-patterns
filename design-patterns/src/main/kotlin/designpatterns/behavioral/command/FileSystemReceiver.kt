package designpatterns.behavioral.command

interface FileSystemReceiver {
    fun openFile()
    fun writeFile()
    fun closeFile()
}
