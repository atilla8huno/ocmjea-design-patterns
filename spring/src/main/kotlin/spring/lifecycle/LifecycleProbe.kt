package spring.lifecycle

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.stereotype.Component

@Component
class LifecycleProbe {
    var started: Boolean = false

    @PostConstruct
    fun start() {
        started = true
    }

    @PreDestroy
    fun stop() {
        started = false
    }
}
