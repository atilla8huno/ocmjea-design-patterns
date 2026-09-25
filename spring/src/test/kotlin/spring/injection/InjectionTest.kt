package spring.injection

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spring.application.SampleApplication

/** Constructor injection, @Primary, @Qualifier, @Autowired on a field, and stereotype annotations. */
@SpringBootTest(classes = [SampleApplication::class])
class InjectionTest @Autowired constructor(
    private val greetingService: GreetingService,
    private val qualifierClient: QualifierClient,
    private val fieldInjectedClient: FieldInjectedClient
) {
    @Test
    fun primaryNotifierIsUsed() {
        assertEquals("email:hello Ada", greetingService.greet("Ada"))
    }

    @Test
    fun qualifierSelectsSms() {
        assertEquals("sms:ping", qualifierClient.ping())
    }

    @Test
    fun fieldAutowiredRepository() {
        assertEquals("saved:note", fieldInjectedClient.repository.save("note"))
    }
}
