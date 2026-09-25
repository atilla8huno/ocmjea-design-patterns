package coroutines.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class NumberChannel {
    suspend fun receive(): List<Int> = coroutineScope {
        val channel = Channel<Int>()
        launch {
            (1..3).forEach { channel.send(it) }
            channel.close()
        }
        buildList {
            for (number in channel) {
                add(number)
            }
        }
    }
}
