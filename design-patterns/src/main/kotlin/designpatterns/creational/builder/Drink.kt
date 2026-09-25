package designpatterns.creational.builder

abstract class Drink : Item {
    override fun packaging(): Packaging = Bottle()
}
