package coroutines.async

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class AsyncCalculator {
    suspend fun add(first: Int, second: Int): Int = coroutineScope {
        async { first + second }.await()
    }
}
