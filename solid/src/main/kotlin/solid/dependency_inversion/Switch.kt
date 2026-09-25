package solid.dependency_inversion

class Switch(private val device: Switchable) {
    fun pressOn() {
        device.turnOn()
    }

    fun pressOff() {
        device.turnOff()
    }
}
