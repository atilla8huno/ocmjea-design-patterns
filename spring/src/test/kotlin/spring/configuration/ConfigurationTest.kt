package spring.configuration

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spring.application.SampleApplication

/**
 * Configuration and profiles
 *
 * Externalise values and vary beans by environment. @Value injects one
 * property; @ConfigurationProperties binds a prefix onto a type; @Bean
 * methods in @Configuration create instances; @Profile activates a bean
 * only for that profile.
 *
 * This test checks those values on the default and extra profiles.
 */
@SpringBootTest(classes = [SampleApplication::class])
class ConfigurationTest @Autowired constructor(
    @param:Qualifier("greetingPrefix") private val greetingPrefix: String,
    private val properties: AppProperties,
    private val context: ApplicationContext
) {
    @Test
    fun readsValueAndConfigurationProperties() {
        assertEquals("hi", greetingPrefix)
        assertEquals("catalogue", properties.title)
        assertNull(context.getBeanNamesForType(String::class.java).firstOrNull { it == "devFlag" })
    }
}
