package designpatterns.behavioral.observer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers Observer by notifying shareholders when share price changes. */
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
