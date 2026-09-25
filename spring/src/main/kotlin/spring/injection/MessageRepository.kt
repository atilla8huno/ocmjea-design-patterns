package spring.injection

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
class MessageRepository {
    fun save(body: String) = "saved:$body"
}

@Component
class FieldInjectedClient {
    @Autowired
    lateinit var repository: MessageRepository
}

@Component
class QualifierClient(
    @param:Qualifier("sms") private val notifier: Notifier
) {
    fun ping() = notifier.notify("ping")
}
