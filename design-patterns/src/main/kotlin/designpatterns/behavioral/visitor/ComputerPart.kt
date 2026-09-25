package designpatterns.behavioral.visitor

interface ComputerPart {
    fun accept(computerPartVisitor: ComputerPartVisitor)
}
