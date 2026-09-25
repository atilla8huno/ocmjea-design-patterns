package coroutines.with_context

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * withContext
 *
 * Run a block on another dispatcher and come back with the result.
 * withContext(Dispatchers.Default) switches for that block only; the
 * caller stays on its original context afterwards.
 *
 * Use it for CPU or IO work without launching a child you then await.
 * This test uppercases "kotlin" on a worker pool.
 */
class WithContextTest {
    @Test
    fun `uppercases text on a worker dispatcher`() = runBlocking {
        val result = ContextProcessor().uppercase("kotlin")

        assertEquals("KOTLIN", result)
    }
}
