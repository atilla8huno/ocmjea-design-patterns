package designpatterns.creational.builder

abstract class Burger : Item {
    override fun packaging(): Packaging = Wrapper()
}
