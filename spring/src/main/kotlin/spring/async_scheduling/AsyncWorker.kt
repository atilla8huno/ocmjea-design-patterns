package spring.async_scheduling

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class AsyncWorker {
    @Async
    fun ping(): CompletableFuture<String> = CompletableFuture.completedFuture("pong")
}
