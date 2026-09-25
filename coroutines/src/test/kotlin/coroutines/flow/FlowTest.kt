package coroutines.flow

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Flow
 *
 * A cold asynchronous stream. Nothing runs until someone collects; each
 * collector starts the upstream again. Operators such as map transform
 * values as they are emitted.
 *
 * A Channel is a live hand-off between coroutines. This test collects
 * NumberFlow.doubled() into [2, 4, 6].
 */
class FlowTest {
    @Test
    fun `collects doubled numbers from a flow`() = runBlocking {
        val values = NumberFlow().doubled().toList()

        assertEquals(listOf(2, 4, 6), values)
    }
}
