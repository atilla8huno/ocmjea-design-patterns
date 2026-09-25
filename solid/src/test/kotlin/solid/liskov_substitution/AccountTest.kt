package solid.liskov_substitution

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Liskov Substitution
 *
 * Subtypes must be usable wherever the base type is expected, without
 * surprising the caller. CurrentAccount and SavingsAccount both honour
 * withdraw() on Account; neither throws or no-ops in a way the list would
 * not expect.
 *
 * This test withdraws 40 from each account through a List of Account and
 * checks the balances.
 */
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
