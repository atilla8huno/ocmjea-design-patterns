package spring.injection

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
@Primary
class EmailNotifier : Notifier {
    override fun notify(message: String) = "email:$message"
}
