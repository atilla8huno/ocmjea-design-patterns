package coroutines.with_context

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContextProcessor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) {
    suspend fun uppercase(text: String): String = withContext(dispatcher) {
        text.uppercase()
    }
}
