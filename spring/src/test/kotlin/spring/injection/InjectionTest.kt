package spring.injection

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spring.application.SampleApplication

/**
 * Dependency injection
 *
 * A bean should not construct its collaborators. Spring creates them and
 * injects them: constructor (preferred), @Primary when several candidates
 * exist, @Qualifier to pick one by name, and field @Autowired.
 *
 * This test checks those four wiring styles and the stereotype beans
 * (@Service, @Component, and so on).
 */
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
