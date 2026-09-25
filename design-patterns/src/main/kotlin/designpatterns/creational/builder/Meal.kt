package designpatterns.creational.builder

class Meal {
    private val items = mutableListOf<Item>()

    fun addItem(item: Item) {
        items.add(item)
    }

    fun getTotal(): Double = items.sumOf { it.price() }

    fun showItems() {
        items.forEach { item ->
            print("Item : ${item.name()}")
            print(", Packaging : ${item.packaging().pack()}")
            println(", Price : ${item.price()}")
        }
    }
}
