package designpatterns.creational.abstract_factory

abstract class AbstractFactory {
    abstract fun getShape(type: String): Shape?
    abstract fun getColour(colour: String): Colour?
}
