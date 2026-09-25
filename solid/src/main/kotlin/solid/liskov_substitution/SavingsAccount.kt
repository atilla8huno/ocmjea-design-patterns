package solid.liskov_substitution

class SavingsAccount(balance: Double) : Account(balance) {
    override fun withdraw(amount: Double) {
        if (amount > balance) {
            println("Savings account: insufficient funds for $amount")
            return
        }
        balance -= amount
        println("Savings account withdrawal: $amount. Balance: $balance")
    }
}
