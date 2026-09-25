package designpatterns.behavioral.command

class WriteFileCommand(private val fileSystem: FileSystemReceiver) : Command {
    override fun execute() {
        fileSystem.writeFile()
    }
}
