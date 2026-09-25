package coroutines.flow

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers Flow by collecting a mapped cold sequence. */
class FlowTest {
    @Test
    fun `collects doubled numbers from a flow`() = runBlocking {
        val values = NumberFlow().doubled().toList()

        assertEquals(listOf(2, 4, 6), values)
    }
}
