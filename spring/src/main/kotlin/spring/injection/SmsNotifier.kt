package spring.injection

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
@Qualifier("sms")
class SmsNotifier : Notifier {
    override fun notify(message: String) = "sms:$message"
}
