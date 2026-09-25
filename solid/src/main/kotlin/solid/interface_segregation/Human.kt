package solid.interface_segregation

class Human : Workable, Feedable {
    override fun work() {
        println("Human working...")
    }

    override fun eat() {
        println("Human eating...")
    }
}
