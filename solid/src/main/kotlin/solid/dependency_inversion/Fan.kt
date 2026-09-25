package solid.dependency_inversion

class Fan : Switchable {
    override fun turnOn() {
        println("Fan on")
    }

    override fun turnOff() {
        println("Fan off")
    }
}
