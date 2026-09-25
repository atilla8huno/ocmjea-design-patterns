package designpatterns.behavioral.visitor

class ComputerPartDisplayVisitor : ComputerPartVisitor {
    override fun visit(computer: Computer) = println("Displaying Computer.")
    override fun visit(mouse: Mouse) = println("Displaying Mouse.")
    override fun visit(keyboard: Keyboard) = println("Displaying Keyboard.")
    override fun visit(monitor: Monitor) = println("Displaying Monitor.")
}
