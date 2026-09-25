package designpatterns.behavioral.visitor

interface ComputerPartVisitor {
    fun visit(computer: Computer)
    fun visit(mouse: Mouse)
    fun visit(keyboard: Keyboard)
    fun visit(monitor: Monitor)
}
