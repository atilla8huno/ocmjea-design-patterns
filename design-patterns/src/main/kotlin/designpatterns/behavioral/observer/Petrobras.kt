package designpatterns.behavioral.observer

class Petrobras {
    private val shareholders = mutableListOf<Shareholder>()
    var sharePrice: Double = 0.0
        set(value) {
            field = value
            notifyShareholders()
        }

    fun addShareholder(shareholder: Shareholder) {
        shareholders.add(shareholder)
    }

    fun notifyShareholders() {
        shareholders.forEach { it.analyseValues() }
    }
}
