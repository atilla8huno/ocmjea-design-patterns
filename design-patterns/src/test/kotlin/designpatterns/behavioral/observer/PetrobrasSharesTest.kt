package designpatterns.behavioral.observer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Observer (Behavioural)
 *
 * One-to-many notification: when the subject changes, all observers are told.
 * Petrobras is the subject; Shareholder A/B/C register and react to the
 * share price. The subject does not know the concrete observer classes.
 *
 * Applicable when several objects must stay in sync with one source. This
 * test updates the price and checks each shareholder is notified.
 */
class PetrobrasSharesTest {
    @Test
    fun `notifies shareholders as share price changes`() {
        val petrobras = Petrobras()

        ShareholderA(petrobras)
        ShareholderB(petrobras)
        ShareholderC(petrobras)

        petrobras.sharePrice = 10.0
        petrobras.sharePrice = 7.0
        petrobras.sharePrice = 16.0
        petrobras.sharePrice = 20.0

        assertEquals(20.0, petrobras.sharePrice)
    }
}
