package designpatterns.behavioral.command

class FileInvoker(var command: Command) {
    fun execute() {
        command.execute()
    }
}
