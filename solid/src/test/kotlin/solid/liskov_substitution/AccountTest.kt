package solid.liskov_substitution

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers LSP by withdrawing through Account subtypes. */
class AccountTest {
    @Test
    fun `withdraws from current and savings accounts interchangeably`() {
        val accounts: List<Account> = listOf(
            CurrentAccount(100.0),
            SavingsAccount(100.0)
        )

        accounts.forEach { it.withdraw(40.0) }

        assertEquals(60.0, accounts[0].currentBalance())
        assertEquals(60.0, accounts[1].currentBalance())
    }
}
