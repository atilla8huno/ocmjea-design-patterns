package solid.dependency_inversion

class Lamp : Switchable {
    override fun turnOn() {
        println("Lamp on")
    }

    override fun turnOff() {
        println("Lamp off")
    }
}
