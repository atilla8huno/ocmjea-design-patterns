package coroutines.with_context

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/** Covers withContext by switching dispatcher and returning a result. */
class WithContextTest {
    @Test
    fun `uppercases text on a worker dispatcher`() = runBlocking {
        val result = ContextProcessor().uppercase("kotlin")

        assertEquals("KOTLIN", result)
    }
}
