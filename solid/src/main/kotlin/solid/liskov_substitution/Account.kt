package solid.liskov_substitution

abstract class Account(protected var balance: Double) {
    abstract fun withdraw(amount: Double)
    fun currentBalance(): Double = balance
}
