package coroutines.cancel

import kotlinx.coroutines.awaitCancellation

class CancellableTask {
    suspend fun execute(): Nothing = awaitCancellation()
}
