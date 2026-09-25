package coroutines.launch

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class LaunchTask {
    suspend fun execute(): String = coroutineScope {
        var result = ""
        val job = launch {
            result = "Task completed"
        }
        job.join()
        result
    }
}
