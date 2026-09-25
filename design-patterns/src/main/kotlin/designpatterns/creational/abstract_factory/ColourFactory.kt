package designpatterns.creational.abstract_factory

class ColourFactory : AbstractFactory() {
    override fun getColour(colour: String): Colour? = when (colour) {
        "blue" -> Blue()
        "red" -> Red()
        else -> null
    }

    override fun getShape(type: String): Shape? = null
}
