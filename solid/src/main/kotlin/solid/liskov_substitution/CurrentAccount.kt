package solid.liskov_substitution

class CurrentAccount(balance: Double) : Account(balance) {
    override fun withdraw(amount: Double) {
        balance -= amount
        println("Current account withdrawal: $amount. Balance: $balance")
    }
}
