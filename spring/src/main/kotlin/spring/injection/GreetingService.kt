package spring.injection

import org.springframework.stereotype.Service

@Service
class GreetingService(private val notifier: Notifier) {
    fun greet(name: String) = notifier.notify("hello $name")
}
