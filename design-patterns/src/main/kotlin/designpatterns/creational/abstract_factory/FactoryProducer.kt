package designpatterns.creational.abstract_factory

object FactoryProducer {
    fun getFactory(factory: String): AbstractFactory? = when (factory) {
        "colour" -> ColourFactory()
        "shape" -> ShapeFactory()
        else -> null
    }
}
