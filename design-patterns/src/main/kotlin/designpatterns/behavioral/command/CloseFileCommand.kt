package designpatterns.behavioral.command

class CloseFileCommand(private val fileSystem: FileSystemReceiver) : Command {
    override fun execute() {
        fileSystem.closeFile()
    }
}
