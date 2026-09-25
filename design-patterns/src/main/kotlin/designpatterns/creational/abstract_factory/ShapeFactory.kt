package designpatterns.creational.abstract_factory

class ShapeFactory : AbstractFactory() {
    override fun getShape(type: String): Shape? = when (type) {
        "circle" -> Circle()
        "square" -> Square()
        else -> null
    }

    override fun getColour(colour: String): Colour? = null
}
