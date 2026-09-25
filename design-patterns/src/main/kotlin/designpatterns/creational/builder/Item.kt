package designpatterns.creational.builder

interface Item {
    fun name(): String
    fun price(): Double
    fun packaging(): Packaging
}
