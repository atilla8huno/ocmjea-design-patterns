package designpatterns.behavioral.command

class OpenFileCommand(private val fileSystem: FileSystemReceiver) : Command {
    override fun execute() {
        fileSystem.openFile()
    }
}
